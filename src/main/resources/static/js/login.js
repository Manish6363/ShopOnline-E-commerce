/**
 * 
 */
// Example: Enabling the login button when both email and password have input
const emailInput = document.getElementById("email");
const passwordInput = document.getElementById("password");
const loginBtn = document.getElementById("login-btn");

function checkLoginInputs() {
	if (emailInput.value.trim() && passwordInput.value.trim()) {
		loginBtn.disabled = false;
	} else {
		loginBtn.disabled = true;
	}
}

emailInput.addEventListener("input", checkLoginInputs);
passwordInput.addEventListener("input", checkLoginInputs);