var ie4 = document.all && !document.getElementById
var ns4
var DOM2 = document.getElementById

if (ns4)
	document
			.write('<ilayer id="zoomerns"><layer id="zoomerns_sub" left=0 top=0></layer></ilayer>')

var index = 10
var mais = 1
var menos = 0

if (DOM2) {
	document.getElementById("zoomer").style.fontSize = index * 10 + 0 + "%";
} else if (ie4) {
	document.all.zoomer.style.fontSize = index * 10 + 0 + "%";
} else if (ns4) {
	document.zoomerns.document.zoomerns_sub.document.write(comments);
	document.zoomerns.document.zoomerns_sub.document.close()
}

function zoom(how) {
	var arr_to_zoom = new Array("esse", "id1", "id2");// Aqui você irá colocar
														// a id onde deve ser
														// alterada a letra!
	if ((index <= 20) && (how == 1))
		index++
	if ((index > 8) && (how == 0))
		index--
	document.getElementById("percent").value = 1 * (index * 10 + 0) + "%"
	if (DOM2) {
		// alert("DOM2");
		for (i = 0; i < arr_to_zoom.length; i++) {
			try {
				document.getElementById(arr_to_zoom[i]).style.fontSize = index
						* 10 + 1 + "%";
			} catch (e) {
			}
		}
	} else if (ie4) {
		// alert("IE4");
		for (i = 0; i < arr_to_zoom.length(); i++) {
			document.getElementById(arr_to_zoom[i]).style.fontSize = index * 10
					+ 1 + "%";
		}
		document.all.zoomer.style.fontSize = index * 10 + 0 + "%";
	} else if (ns4) {
		// alert("ns4");
		document.zoomerns.document.zoomerns_sub.document.write(comments);
		document.zoomerns.document.zoomerns_sub.document.close();
	}
}