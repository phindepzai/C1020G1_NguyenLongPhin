import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.scss']
})
export class PetComponent implements OnInit {
  ngOnInit;
  petName = 'pepe';
  petImage = 'https://tokago.vn/uploads/2019/5/22/11/9/e7ed0c29d5986124d21d8def1967bc9a.png';
  constructor() { }

  updateName(name) {
    this.petName = name;
  }

  OnInit() { }

  updateImage(image) {
    if (image === '') {
      this.petImage = 'https://tokago.vn/uploads/2019/5/22/11/9/e7ed0c29d5986124d21d8def1967bc9a.png';
    } else {
      this.petImage = image;
    }
  }

}
