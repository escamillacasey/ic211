
function startit() {
	var H = 10; var W = 30;
	var s = document.body.innerHTML;
	var lines = [ "" ];
	var n = 0, i = 0;
	while(i < s.length) {
		if (s[i] == "\n") {
			n++;
			lines[n] = "";
		} else if (s[i] == "\r") {
			;
		} else {
			if (s[i] == "\t") {
				lines[n] += "     ";
			} else {
				lines[n] += s[i];
			}
		}
		i++;
	}

	function showChunk(srow, scol) {
		var count = 0;
		var news = "";
		var i = srow;
		while(i < H+srow && i < lines.length) {
			var j = scol;
			while(j < W+scol && j < lines[i].length) {
				var c = lines[i][j];
				var d = c;
				count++;
				if (c == "<") { d = "&lt;"; }
				else if (c == ">") { d = "&gt;"; }
				else if (c == "&") { d = "&amp;"; }
				else if (c == " ") { d = "&nbsp;"; count--; }
				// else if (c == "\t") { d = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"; count--;}
				news += d;
				j++;
			}
			news += "<br>\n";
			i++;
		}
		document.getElementById('port').innerHTML = news;
		return count;
	}

	var currRow = 0, currCol = 0, deltaRow = 1, deltaCol = 1;

	showChunk(currRow,currCol);
	function randDirChange(d) {
		if (d == -1 || d == 1) return 0;
		if (Math.random() < 0.5) return -1; else return 1;
	}

	intervalID = setInterval(function() {
      currCol += deltaCol; if (currCol == -1) { currCol = 0; deltaCol = 1; }
      currRow += deltaRow; if (currRow == -1) { currRow = 0; deltaRow = 1; }
      if (currRow > lines.length - H/2 ) { deltaRow = -1; }
      count = showChunk(currRow,currCol);
      if (count == 0 && deltaCol == 1) { deltaCol = -1; }
      if (count == 0 && deltaRow == 1) { deltaRow = -1; }
      if (count > 0 && Math.random() < 0.05)
      {
	if (Math.random() < 0.5) { deltaCol = randDirChange(deltaCol); }
	else { deltaRow = randDirChange(deltaRow); }
	if (deltaRow == 0 && deltaCol == 0)
	  if (Math.random() < 0.5) { deltaCol = randDirChange(deltaCol); }
	  else { deltaRow = randDirChange(deltaRow); }
      }
    },100);
}

var intervalID = null, today = new Date();

// Date is YEAR, MONTH, DAY, HOUR, MINUTE)  Don't forget that the months start on 0!

if(today>new Date(2020,8,25,12,45,0) && today<new Date(2030,9,8,16,30,0)) {
	intervalID = setInterval(function() {
	document.body.innerHTML='<IMG src="http://courses.cs.usna.edu/SY110/resources/15.lb/msg.png" style="width:100%;">';
    },3000);
} else {
	document.write('<div style="float: right; color: #000084; font-family: monospace; font-size: 10pt;">this is your body<br> <div id="port" style="color: #000084; font-family: monospace; font-size: 6pt; width: 100pt; height: 60pt; float: right; border-style: solid; border-width: 2pt; overflow:hidden; white-space:nowrap;">  </div></div>');
//document.write('<div id="port" style="color: #000084; font-family: monospace; font-size: 6pt; width: 100pt; height: 60pt; float: right; border-style: solid; border-width: 2pt; overflow:hidden; white-space:nowrap;">  </div>');
}

document.body.onload = startit;
