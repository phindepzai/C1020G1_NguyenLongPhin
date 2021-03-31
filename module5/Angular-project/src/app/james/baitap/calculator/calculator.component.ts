import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})
export class CalculatorComponent implements OnInit {
  firstNumber = 0;
  secondNumber = 0;
  operate = '+';
  result: number;

  constructor() { }

  ngOnInit(): void {
  }

  getResult() {
    if (isNaN(this.firstNumber)){
      this.firstNumber = 0;
    }
    if (isNaN(this.secondNumber)){
      this.secondNumber = 0;
    }
    switch (this.operate) {
      case '+':
        this.result = this.firstNumber + this.secondNumber;
        break;
      case '-':
        this.result = this.firstNumber - this.secondNumber;
        break;
      case '*':
        this.result = this.firstNumber * this.secondNumber;
        break;
      default:
        this.result = this.secondNumber === 0 ? 0 : this.firstNumber / this.secondNumber;
    }
  }

  setFirstNumber(firstNumber) {
    // tslint:disable-next-line:radix
    this.firstNumber = Number.parseInt(firstNumber);
    this.getResult();
  }

  setSecondNumber(secondNumber) {
    // tslint:disable-next-line:radix
    this.secondNumber = Number.parseInt(secondNumber);
    this.getResult();
  }

  setOperate(operate){
    this.operate = operate;
    this.getResult();
  }
}
