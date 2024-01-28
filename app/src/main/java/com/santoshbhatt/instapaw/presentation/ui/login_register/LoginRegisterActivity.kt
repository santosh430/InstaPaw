package com.santoshbhatt.instapaw.presentation.ui.login_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.santoshbhatt.instapaw.R
import com.santoshbhatt.instapaw.core.util.LogType
import com.santoshbhatt.instapaw.core.util.Logcat
import com.santoshbhatt.instapaw.databinding.ActivityLoginRegisterBinding
import javax.inject.Inject

class LoginRegisterActivity @Inject constructor() : AppCompatActivity() {
    private val TAG = "LoginRegisterActivity"
    private lateinit var binding: ActivityLoginRegisterBinding
    private val loginViewModel by viewModels<LoginRegisterViewModel> { LoginRegisterViewModel.LoginRegisterViewModelFactory }
    private var oneTapClient: SignInClient? = null
    private var signInRequest:BeginSignInRequest? = null
    private var firebaseAuth:FirebaseAuth? = null
    private var showOneTapUI = true

    private var logInResultHandler = registerForActivityResult(
        ActivityResultContracts.StartIntentSenderForResult()
    ) { result1: ActivityResult ->
        try {
            val credential =
                oneTapClient?.getSignInCredentialFromIntent(result1.data)
            val idToken = credential?.googleIdToken
            if (idToken != null) {
                // Got an ID token from Google. Use it to authenticate
                // with Firebase.
                result1.data?.let { signInWithGoogle(it) }
                Log.d("TAG", "Got ID token. $idToken")
            }
        } catch (e: ApiException) {
            when (e.statusCode) {
                CommonStatusCodes.CANCELED -> {
                    run {
                        Log.d("one tap", "One-tap dialog was closed.")
                        // Don't re-prompt the user.
                        showOneTapUI = false
                    }
                }
                CommonStatusCodes.NETWORK_ERROR -> {
                    run {
                        Log.d("one tap", "One-tap encountered a network error.")
                        showOneTapUI = false
                    }

                }
                else -> {
                    Log.d(
                        "one tap", "Couldn't get credential from result." +
                                e.localizedMessage
                    )
                    showOneTapUI = false
                }
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            binding = ActivityLoginRegisterBinding.inflate(layoutInflater)
            setContentView(binding.root)
            supportActionBar?.hide()

            firebaseAuth = FirebaseAuth.getInstance()
            oneTapClient = Identity.getSignInClient(this)

            Logcat.printLog(TAG,LogType.Debug,"viewmodel: $loginViewModel")
            binding.apply {
                tvRegisterLogin.setOnClickListener {
                    clLoginExistingUser.visibility = View.GONE
                    clRegisterNewUser.visibility = View.VISIBLE
                }
                tvSignIn.setOnClickListener {
                    clRegisterNewUser.visibility = View.GONE
                    clLoginExistingUser.visibility = View.VISIBLE
                }
                btnGoogleSignIn.setOnClickListener {
                    initiateGoogleSignIn()
                }
                btnRegisterGoogleSignIn.setOnClickListener {
                    initiateGoogleSignIn()
                }
                btnCreateAcc.isEnabled = true
                btnCreateAcc.setOnClickListener {
                    registerNewUser(etNewUserUsername.text.toString(),etNewUserPassword.text.toString())
                }

                login.isEnabled = true
                login.setOnClickListener {
                    logInUser(email.text.toString(),password.text.toString())
                }

            }

            Logcat.printLog(TAG,LogType.Debug,"currentUser: ${firebaseAuth?.currentUser?.email}")



        }catch (exception:Exception){
            Logcat.printLog(TAG,LogType.Error,"onCreate(): ",exception)
        }
    }

    /**
     * @param afterTextChange takes the lambda which acts as a callback.
     *
     * Generic function to use functionality of afterTextChanged() of TextInputEditText.
     */
    fun TextInputEditText.addTextChangedListener(afterTextChange: ()->Unit ){
        this.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                afterTextChange.invoke()
            }
        })
    }

    private fun registerNewUser(email: String, password: String) {
        try {
            firebaseAuth?.createUserWithEmailAndPassword(
                email,
                password
            )
                ?.addOnCompleteListener(
                    this
                ) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("TAG", "createUserWithEmail:success")
                        val user = firebaseAuth?.currentUser

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.e("TAG", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            this,
                            "" + task.exception?.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }catch (exception:Exception){
            Logcat.printLog(TAG,LogType.Error,"registerNewUser(): ",exception)
        }
    }

    private fun logInUser(email: String, password: String) {
        try {
            if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
                firebaseAuth?.signInWithEmailAndPassword(
                    email,
                    password
                )
                    ?.addOnCompleteListener(
                        this
                    ) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success")
                            //FirebaseUser user = firebaseAuth.getCurrentUser();
                            val user = firebaseAuth?.currentUser
//                            updateUI(user, UserLogInMode.SignIn(LoginMode.EMAIL))
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.exception)
                            Toast.makeText(
                                this,
                                "Authentication failed due to " + task.exception!!.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }catch (exception:Exception){
            Logcat.printLog(TAG,LogType.Error,"logInUser(): ",exception)
        }
    }

    private fun initiateGoogleSignIn() {
        try {
            signInRequest = BeginSignInRequest.builder()
                .setGoogleIdTokenRequestOptions(
                    BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                        .setSupported(true)
                        // Your server's client ID, not your Android client ID.
                        .setServerClientId(getString(R.string.web_client_id))
                        // Only show accounts previously used to sign in.
                        .setFilterByAuthorizedAccounts(false)
                        .build()
                )
                .build()

            oneTapClient?.beginSignIn(signInRequest ?: return)
                ?.addOnSuccessListener(
                    this
                ) { result ->
                    val intentSenderRequest =
                        IntentSenderRequest.Builder(result.pendingIntent.intentSender).build()
                    logInResultHandler.launch(intentSenderRequest)
                    //                            startIntentSenderForResult(
                    //                                    result.getPendingIntent().getIntentSender(), REQ_ONE_TAP,
                    //                                    null, 0, 0, 0);
                }
                ?.addOnFailureListener(this) { e -> // No saved credentials found. Launch the One Tap sign-up flow, or
                    // do nothing and continue presenting the signed-out UI.

                    Log.d("TAG Failure Listener", e.localizedMessage as String)
                }
        }catch (exception:Exception){
            Logcat.printLog(TAG,LogType.Error,"initiateGoogleSignIn() : ",exception)
        }
    }

    @Throws(ApiException::class)
    private fun signInWithGoogle(data: Intent) {
        val googleCredential = oneTapClient?.getSignInCredentialFromIntent(data)
        val idToken = googleCredential?.googleIdToken
        if (idToken != null) {
            // Got an ID token from Google. Use it to authenticate
            // with Firebase.
            val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
            firebaseAuth?.signInWithCredential(firebaseCredential)
                ?.addOnCompleteListener(this, object : OnCompleteListener<AuthResult?> {
                    override fun onComplete(task: Task<AuthResult?>) {
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithCredential:success")
                            val user = firebaseAuth?.currentUser
//                            updateUI(user, UserLogInMode.SignIn(LoginMode.GOOGLE))
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithCredential:failure", task.exception)
//                            updateUI(null)
                        }
                    }
                })
        }
    }
}