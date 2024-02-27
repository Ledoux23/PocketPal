import { Component, OnInit } from '@angular/core';
import { ExpenseService } from '../services/expense.service';


@Component({
  selector: 'app-home',
  /*standalone: true,
  imports: [], */
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit  {

  //public title = 'Gestion des dépenses personnelles';
  public expenses: any[] = [];
  public totalAmount: number = 0;

  constructor(
    private expenseService: ExpenseService,
    //private router: Router
  ) {}

  ngOnInit() {
    this.fetchExpenses(); // Appel de la méthode pour récupérer les tâches depuis le backend
  }

  fetchExpenses() {
    this.expenseService.getAllExpenses()
      .subscribe(
        (response: any[]) => {
          this.expenses = response;
          this.calculateTotalAmount();
          console.log('Données récupérées du backend :', this.expenses);
        }
      );
  }

  calculateTotalAmount() {
    this.totalAmount = this.expenses.reduce((total, expense) => total + expense.amount, 0);
  }

}

/**
 
import { Component, AfterViewInit, ElementRef, ViewChild } from '@angular/core';
import { ExpenseService } from '../services/expense.service';
import Chart from 'chart.js/auto';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements AfterViewInit {

  public expenses: any[] = [];
  @ViewChild('myChart') myChart!: ElementRef;

  constructor(private expenseService: ExpenseService) {}

  ngAfterViewInit() {
    this.fetchExpenses();
  }

  fetchExpenses() {
    this.expenseService.getAllExpenses()
      .subscribe(
        (response: any[]) => {
          this.expenses = response;
          if (this.myChart && this.expenses.length > 0) {
            this.initChart();
          }
        }
      );
  }

  initChart() {
    const ctx = this.myChart.nativeElement.getContext('2d');
    const myChart = new Chart(ctx, {
      type: 'bar',
      data: {
        labels: this.expenses.map(expense => expense.description),
        datasets: [{
          label: 'Amount',
          data: this.expenses.map(expense => expense.amount),
          backgroundColor: 'rgba(255, 99, 132, 0.2)',
          borderColor: 'rgba(255, 99, 132, 1)',
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
  }
}

 */
