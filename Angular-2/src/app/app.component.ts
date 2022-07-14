import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"],
})
export class AppComponent {
  postTexts = [
    "Hallo mein Name ist Werner! Ich bin hier, um neue Freunde zu finden!",
    "Hey, mein Name ist Rainer. Ich bin 5 Jahre alt",
    "Ich esse gerne Kekse!",
    "Ich liebe es, wenn jemand mich fragt, wie es um die Kekse geht!",
  ];

  postImages = [
    "assets/img/Hamster/1.jpg",
    "assets/img/Hamster/2.jpg",
    "assets/img/Hamster/3.jpg",
    "assets/img/Hamster/4.jpg",
  ];

  buttonClicked() {
    alert("Hallo, wie geht es dir?");
  }
}
