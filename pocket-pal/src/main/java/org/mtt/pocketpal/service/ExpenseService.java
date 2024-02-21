package org.mtt.pocketpal.service;

import org.mtt.pocketpal.model.Expense;
import org.mtt.pocketpal.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public Expense updateExpense(Long id, Expense expense) {
        return expenseRepository.findById(id)
                .map(existingExpense -> {
                    // Mettre à jour les attributs de la dépense existante avec les valeurs fournies
                    existingExpense.setDescription(expense.getDescription());
                    existingExpense.setAmount(expense.getAmount());
                    existingExpense.setDate(expense.getDate());
                    // Enregistrer la dépense mise à jour dans la base de données
                    return expenseRepository.save(existingExpense);
                })
                .orElse(null); // Si la dépense avec l'ID spécifié n'existe pas, retourner null
    }
}
