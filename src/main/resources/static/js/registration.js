const emailInput = document.getElementById("email");
const sendOtpBtn = document.getElementById("sendOtpBtn");
const otpInput = document.getElementById("otpInput");
const otpMessage = document.getElementById("otpMessage");
const registerForm = document.getElementById("registerForm");
const registerBtn = document.getElementById("registerBtn");

// Form fields
const name = document.getElementById("name");
const sellerName = document.getElementById("sellerName");
const gstNo = document.getElementById("gstNo");
const shopName = document.getElementById("shopName");
const mobile = document.getElementById("mobile");
const password = document.getElementById("password");
const confirmPassword = document.getElementById("confirmPassword");
const dob = document.getElementById("dob");
const genderRadios = document.querySelectorAll("input[name='gender']");

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



	document.getElementById("mobileError").textContent = "";
	document.getElementById("passwordError").textContent = "";
	document.getElementById("confirmPasswordError").textContent = "";

	if (role === "User") {
		document.getElementById("nameError").textContent = "";
		if (name.value.trim() === "") {
			document.getElementById("nameError").textContent = "Name is required.";
			isValid = false;
		}
		if (dob.value === "") {
			isValid = false;
		}

		const selectedGender = [...genderRadios].some(r => r.checked);
		if (!selectedGender) {
			isValid = false;
		}
	} else {
		document.getElementById("sellerNameError").textContent = "";
		document.getElementById("gstNoError").textContent = "";
		document.getElementById("shopNameError").textContent = "";
		if (sellerName.value.trim() === "") {
			document.getElementById("sellerNameError").textContent = "Seller name is required.";
			isValid = false;
		}
		if (gstNo.value.trim() === "") {
			document.getElementById("gstNoError").textContent = "GST Number is required.";
			isValid = false;
		}
		if (shopName.value.trim() === "") {
			document.getElementById("shopNameError").textContent = "Seller name is required.";
			isValid = false;
		}
	}

	if (!/^\d{10}$/.test(mobile.value.trim())) {
		document.getElementById("mobileError").textContent = "Enter a valid 10-digit mobile number.";
		isValid = false;
	}

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

if (role === "User") {
	[name, mobile, password, confirmPassword, dob, ...genderRadios].forEach(field =>
		field.addEventListener("input", validateForm)
	);
} else {
	[sellerName, gstNo, shopName, mobile, password, confirmPassword].forEach(field =>
		field.addEventListener("input", validateForm)
	);
}
