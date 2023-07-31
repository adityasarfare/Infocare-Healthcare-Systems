import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-multiplication',
  templateUrl: './multiplication.component.html',
  styleUrls: ['./multiplication.component.css']
})
export class MultiplicationComponent {
  num1 = 0;
  num2 = 0;
  result: number | null = null;

  constructor(private http: HttpClient) { }

  multiply(): void {
    const requestData = {
      num1: this.num1,
      num2: this.num2
    };

    this.http.post<number>('http://localhost:8090/multiply', requestData)
      .subscribe(
        (response) => {
          this.result = response;
        },
        (error) => {
          console.error('Error:', error);
        }
      );
  }
}
