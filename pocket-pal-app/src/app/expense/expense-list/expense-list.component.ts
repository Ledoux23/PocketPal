import { Component, OnInit } from '@angular/core';
import { ExpenseService } from '../expense.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-expense-list',
  templateUrl: './expense-list.component.html',
  styleUrls: ['./expense-list.component.css']
})
export class ExpenseListComponent implements OnInit  {

  public title = 'To-do-list';
  public expenses: any[] = [];

  constructor(
    private expenseService: ExpenseService,
    private router: Router
  ) {}

  ngOnInit() {
    this.fetchExpenses(); // Appel de la méthode pour récupérer les tâches depuis le backend
  }

  fetchExpenses() {
    this.expenseService.getAllExpenses()
      .subscribe(
        (response: any[]) => {
          this.expenses = response;
          console.log('Données récupérées du backend :', this.expenses);
        }
      );
  }

}
