function solution(new_id) {
  // 1단계
  var str1 = new_id.toLowerCase();

  // 2단계
  var str2 = "";
  for (var i = 0; i < str1.length; i++) {
    var c = str1.charAt(i);
    if (
      (c >= "a" && c <= "z") ||
      (c >= "0" && c <= "9") ||
      c == "-" ||
      c == "_" ||
      c == "."
    ) {
      str2 += c;
    }
  }

  // 3단계
  while (str2.indexOf("..") >= 0) {
    str2 = str2.replace("..", ".");
  }

  // 4단계
  if (str2.length > 0 && str2.charAt(0) == ".") {
    str2 = str2.substring(1);
  }
  if (str2.length > 0 && str2.charAt(str2.length - 1) == ".") {
    str2 = str2.substring(0, str2.length - 1);
  }

  // 5단계
  if (str2.length == 0) {
    str2 = "a";
  }

  // 6단계
  if (str2.length >= 16) {
    str2 = str2.substring(0, 15);

    while (str2.charAt(str2.length - 1) == ".") {
      str2 = str2.substring(0, str2.length - 1);
    }
  }

  // 7단계
  while (str2.length <= 2) {
    str2 += str2.charAt(str2.length - 1);
  }

  return str2;
}
