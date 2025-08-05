const emailInput = document.getElementById("email");
const sendOtpBtn = document.getElementById("sendOtpBtn");
const otpInput = document.getElementById("otpInput");
const otpMessage = document.getElementById("otpMessage");
const registerForm = document.getElementById("registerForm");
const registerBtn = document.getElementById("registerBtn");

// Form fields
const password = document.getElementById("password");
const confirmPassword = document.getElementById("confirmPassword");

// Enable Send OTP button if email is valid
function validateEmail(email) {
	const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	return re.test(email);
}

if (emailInput && !emailInput.readOnly) {
	emailInput.addEventListener("input", () => {
		if (validateEmail(emailInput.value)) {
			sendOtpBtn.disabled = false;
			sendOtpBtn.style.backgroundColor = "blue";
			sendOtpBtn.style.cursor = "pointer";
		} else {
			sendOtpBtn.disabled = true;
			sendOtpBtn.style.backgroundColor = "gray";
			sendOtpBtn.style.cursor = "not-allowed";
		}
	});
}

// OTP verification
function verifyOtp() {
	const enteredOtp = otpInput.value.trim();

	if (enteredOtp.length !== 6) {
		otpMessage.textContent = "OTP must be exactly 6 digits.";
		otpMessage.style.color = "red";
		return;
	}

	if (parseInt(enteredOtp) === actualOtp) {
		otpMessage.textContent = "OTP verified successfully!";
		otpMessage.style.color = "green";

		registerForm.classList.remove("hidden");
		document.getElementById("otpSection").style.display = "none";

		validateForm();
	} else {
		otpMessage.textContent = "Invalid OTP. Please try again.";
		otpMessage.style.color = "red";
	}
}

// Form validation
function validateForm() {
	let isValid = true;

	document.getElementById("passwordError").textContent = "";
	document.getElementById("confirmPasswordError").textContent = "";

	
	if (password.value.trim() === "") {
		document.getElementById("passwordError").textContent = "Password is required.";
		isValid = false;
	}

	if (confirmPassword.value.trim() === "") {
		document.getElementById("confirmPasswordError").textContent = "Confirm your password.";
		isValid = false;
	} else if (password.value !== confirmPassword.value) {
		document.getElementById("confirmPasswordError").textContent = "Passwords do not match.";
		isValid = false;
	}

	registerBtn.disabled = !isValid;
}

[password, confirmPassword].forEach(field =>
	field.addEventListener("input", validateForm)
);
