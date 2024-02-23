export class Expense {
    constructor(
      public description: string,
      public amount: number,
      public date: Date,
      // Ajouter d'autres propriétés ici si nécessaire
    ) {}
  }