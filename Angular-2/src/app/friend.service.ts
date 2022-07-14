import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class FriendService {
  names = ["Sascha"];
  texts = ["2 Jahre alt"];
  images = ["assets/img/Hamster/6.jpg"];

  constructor() {}

  //addFriend('Peter', 'Hallo', /assets/img/Hamster/1.jpg');

  addFriend(name, text, image) {
    this.names.push(name);
    this.texts.push(text);
    this.images.push(image);
  }
}
