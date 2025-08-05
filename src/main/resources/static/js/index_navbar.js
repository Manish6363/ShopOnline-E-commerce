function toggleDrawer() {
	document.getElementById("drawer").classList.toggle("open");
}

function redirectToLogin(select) {
	const selectedValue = select.value;
	if (selectedValue === "admin") {
		window.location.href = "adminLogin";
	} else if (selectedValue === "seller") {
		window.location.href = "sellerLogin";
	}
}

function redirectToCategory(select) {
	const selectedValue = select.value;
	if (selectedValue) {
		window.location.href = selectedValue;
	}
}

function toggleProfileOptions() {
	document.getElementById("profileOptions").classList.toggle("open");
}

// Close the profile dropdown if the user clicks outside of it
window.onclick = function(event) {
	if (
		!event.target.matches(".profile-icon") &&
		!event.target.closest(".profile-icon")
	) {
		var dropdowns = document.getElementsByClassName("profile-options");
		for (var i = 0; i < dropdowns.length; i++) {
			var openDropdown = dropdowns[i];
			if (openDropdown.classList.contains("open")) {
				openDropdown.classList.remove("open");
			}
		}
	}
};


function openImageUploadModal() {
	document.getElementById("imageUploadModal").style.display = "block";
}

function closeImageUploadModal() {
	document.getElementById("imageUploadModal").style.display = "none";
}

// Optional: Close modal when clicking outside of it
window.onclick = function(event) {
	const modal = document.getElementById("imageUploadModal");
	if (event.target === modal) {
		closeImageUploadModal();
	}
}


//-------------------------------------

function openChangePasswordModal() {
	document.getElementById("changePasswordModal").style.display = "block";
}

function closeChangePasswordModal() {
	document.getElementById("changePasswordModal").style.display = "none";
}

// Optional: Close modal when clicking outside of it
window.onclick = function(event) {
	const modal = document.getElementById("changePasswordModal");
	if (event.target === modal) {
		closeChangePasswordModal();
	}
}

//-------------------------------------

function openWalletModal() {
	document.getElementById("walletModal").style.display = "block";
}

function closeWalletModal() {
	document.getElementById("walletModal").style.display = "none";
}

// Optional: Close modal when clicking outside of it
window.onclick = function(event) {
	const modal = document.getElementById("walletModal");
	if (event.target === modal) {
		closeWalletModal();
	}
}

//-------------------------------------

function openTransactionModal() {
	document.getElementById("transactionModal").style.display = "block";
}

function closeTransactionModal() {
	document.getElementById("transactionModal").style.display = "none";
}

// Optional: Close modal when clicking outside of it
window.onclick = function(event) {
	const modal = document.getElementById("transactionModal");
	if (event.target === modal) {
		closeTransactionModal();
		closeWalletModal();
	}
}





function openAddressModal() {
	document.getElementById("addressModal").style.display = "block";
}

function closeAddressModal() {
	document.getElementById("addressModal").style.display = "none";
}

// Optional: Close modal when clicking outside
window.onclick = function(event) {
	const modal = document.getElementById("addressModal");
	if (event.target === modal) {
		closeAddressModal();
	}
}


function openAddAddressModal() {
	document.getElementById("addAddressModal").style.display = "block";
}

function closeAddAddressModal() {
	document.getElementById("addAddressModal").style.display = "none";
}

// Optional: Close modal when clicking outside of it
window.onclick = function(event) {
	const modal = document.getElementById("addAddressModal");
	if (event.target === modal) {
		closeAddAddressModal();
		closeAddressModal();
	}
}