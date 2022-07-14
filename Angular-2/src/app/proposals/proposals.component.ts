import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-proposals',
  templateUrl: './proposals.component.html',
  styleUrls: ['./proposals.component.scss']
})
export class ProposalsComponent implements OnInit {

  names = ['Sascha', 'Heinz', 'Helga', 'Elke'];
  texts = ['2 Jahre alt', 'Gräbt gerne Löcher', 'Spielt gerne', 'Ein Hamsterrad-Freak'];
  images = ['assets/img/Hamster/5.jpg', 'assets/img/Hamster/6.jpg', 'assets/img/Hamster/7.jpg', 'assets/img/Hamster/8.jpg'];

  constructor() { }

  ngOnInit(): void {
  }

}
