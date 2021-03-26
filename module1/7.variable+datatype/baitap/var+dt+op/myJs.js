function bai1() {
    let vatLy = parseInt(prompt('nhập vào điểm vật lý:'));
    let hoaHoc = parseInt(prompt('nhập vào điểm hóa học:'));
    let sinhHoc = parseInt(prompt('nhập vào điểm sinh học:'));
    let diemTb = (vatLy + hoaHoc + sinhHoc)/3;
    alert('điểm trung bình: '+diemTb);
}
function bai2() {
    let doC = parseInt(prompt('nhập vào độ C:'));
    let doF = 9*(doC/5) + 32;
    alert('độ F: '+doF);
}
const PI=3.14;
function bai3() {
    let r = parseInt(prompt('nhập vào bán kính hình tròn(m): '));
    let s = PI*r*r;
    alert('diện tích hình tròn: '+s+'m2');
}
function bai4() {
    let r = parseInt(prompt('nhập vào bán kính hình tròn(m): '));
    let v = 2*PI*r;
    alert('chu vi hình tròn: '+v+'m');
}