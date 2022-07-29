import { Component, OnInit } from '@angular/core';
import {EsbServiceService} from "../services/esb-service.service";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  res: any;

  constructor(private service: EsbServiceService) { }

  ngOnInit(): void {
    this.res = this.service.getResponse();
    this.service.getBlocco();
  }

}
