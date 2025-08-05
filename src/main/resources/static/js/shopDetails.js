function openModal() {
    document.getElementById("actionModal").style.display = "block";
  }

  function closeModal() {
    document.getElementById("actionModal").style.display = "none";
  }

  // Optional: close modal on outside click
  window.onclick = function(event) {
    const modal = document.getElementById("actionModal");
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }