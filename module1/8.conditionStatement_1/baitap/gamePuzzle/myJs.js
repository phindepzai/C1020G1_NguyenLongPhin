function swapAnh(num) {
    let hinh = document.getElementById('img'+num);
    console.log(hinh.src);
    let addMonkey = "file:///E:/C1020G1_NguyenLongPhin/module1/8.conditionStatement_1/baitap/gamePuzzle/image/monkey_"+num+".jpg";
    let addPanda = "file:///E:/C1020G1_NguyenLongPhin/module1/8.conditionStatement_1/baitap/gamePuzzle/image/panda_"+num+".jpg"
    if (hinh.src === addPanda){
        hinh.src = addMonkey;
    }else{
        hinh.src = addPanda;
    }
}