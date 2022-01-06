function solution(lottos, win_nums) {
    var good = 7, bad = 7;
    
    for (var i = 0; i < 6; i++) {
        // 알아볼 수 없는 번호
        if (lottos[i] == 0) {
            good--;
            continue;
        }
        
        // 당첨 번호인지 검사
        for (var j = 0; j < 6; j++) {
            if (lottos[i] == win_nums[j]) {
                good--;
                bad--;
                break;
            }
        }
    }
    
    var answer = [Math.min(good, 6), Math.min(bad, 6)];
    
    return answer;
}