function bai1() {
    let i = 10;
    let f = 20.5;
    let b = true;
    let s = 'Hà Nội';

    document.write('i = ' + i);
    document.write('<br/>');
    document.write('f = ' + f);
    document.write('<br/>');
    document.write('b = ' + b);
    document.write('<br/>');
    document.write('s = ' + s);
}
function bai2() {
    let width = 20
    let height = 10
    let area = width * height
    document.write('Area = ' + area)
}
function bai3() {
    let a = prompt('nhập a : ');
    let b = prompt('nhập b : ');
    if (a % 2 == 0){
        alert('a là bội của b');
    }else {
        alert('a không phải là bội của b');
    }
}