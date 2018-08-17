window.onload = function() {
	document.getElementById("testAjax").addEventListener("click",
			ajax);
}

function ajax() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let ajaxObject = JSON.parse(xhttp.responseText);
			console.log(ajaxObject);
			document.getElementById("testAjax").innerHTML = ajaxObject;
		}
	};
	xhttp.open("GET", "http://localhost:8181/Project2/hello.do", true);
	xhttp.send();
}