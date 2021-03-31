import { Component, OnInit } from '@angular/core';
import { Likes } from 'src/app/model/Likes';

@Component({
  selector: 'app-hackernews',
  templateUrl: './hackernews.component.html',
  styleUrls: ['./hackernews.component.scss']
})
export class HackernewsComponent implements OnInit {
  articles = [
    {
      title: 'The Evolution of Async JavaScript: From Callbacks, to Promises, to Async/Await',
      url: 'https://medium.freecodecamp.org/the-evolution-of-async-javascript-from-callbacks-to-promises-to-async-await-e73b047f2f40',
      likes: new Likes()
    },
    {
      title: 'Game of Life',
      url: 'https://thefullsnack.com/posts/game-of-life.html',
      likes: new Likes()
    },
    {
      title: 'Nguyên tắc thiết kế REST API',
      url: 'https://medium.com/eway/nguyên-tắc-thiết-kế-rest-api-23add16968d7',
      likes: new Likes()
    },
    {
      title: 'Why You Only Need to Test with 5 Users',
      url: 'https://www.nngroup.com/articles/why-you-only-need-to-test-with-5-users/',
      likes: new Likes()
    },
    {
      title: 'Let’s Build A Web Server. Part 1.',
      url: 'https://ruslanspivak.com/lsbaws-part1/',
      likes: new Likes()
    }
  ];
  constructor() { }

  ngOnInit(): void {
  }

  update(tag): void{
    tag = tag.parentNode;
    if (tag.innerText === 'update'){
      tag.parentNode.children[1].firstChild.readOnly = false;
      tag.parentNode.children[2].firstChild.readOnly = false;
      tag.firstChild.innerText = 'save';
    } else {
      tag.parentNode.children[1].firstChild.readOnly = true;
      tag.parentNode.children[2].firstChild.readOnly = true;
      tag.innerText.firstChild = 'update';
    }
  }
}
