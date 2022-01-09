function solution(s) {
  var answer = s.replace(/zero/g, 0);
  answer = answer.replace(/one/g, 1);
  answer = answer.replace(/two/g, 2);
  answer = answer.replace(/three/g, 3);
  answer = answer.replace(/four/g, 4);
  answer = answer.replace(/five/g, 5);
  answer = answer.replace(/six/g, 6);
  answer = answer.replace(/seven/g, 7);
  answer = answer.replace(/eight/g, 8);
  answer = answer.replace(/nine/g, 9);

  return answer * 1;
}
