/**
 * 
 */

function startConfetti() {
	setInterval(() => {
		for (let i = 0; i < 5; i++) {
			const confetti = document.createElement("div");
			confetti.classList.add("confetti");

			confetti.style.background = getRandomColor();
			confetti.style.left = `${Math.random() * 100}%`;

			const size = Math.random() * 8 + 8;
			confetti.style.width = `${size}px`;
			confetti.style.height = `${size}px`;
			confetti.style.animationDuration = `${Math.random() * 2 + 1.5}s`;
			confetti.style.transform = `rotate(${Math.random() * 360}deg)`;

			document.getElementById("confetti-container").appendChild(confetti);

			setTimeout(() => confetti.remove(), 4000);
		}
	}, 150);
}

function getRandomColor() {
	const colors = [
		"#f44336",
		"#e91e63",
		"#9c27b0",
		"#2196f3",
		"#4caf50",
		"#ffc107",
		"#ff5722",
	];
	return colors[Math.floor(Math.random() * colors.length)];
}

window.onload = startConfetti;