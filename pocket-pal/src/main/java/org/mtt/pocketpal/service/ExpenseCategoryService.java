package org.mtt.pocketpal.service;

import org.mtt.pocketpal.model.ExpenseCategory;
import org.mtt.pocketpal.repository.ExpenseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ExpenseCategoryService {

    @Autowired
    private ExpenseCategoryRepository expenseCategoryRepository;

    public List<ExpenseCategory> getAllExpenseCategories() {
        return expenseCategoryRepository.findAll();
    }

    public Optional<ExpenseCategory> getExpenseCategoryById(Long id) {
        return expenseCategoryRepository.findById(id);
    }

    public ExpenseCategory createExpenseCategory(ExpenseCategory category) {
        return expenseCategoryRepository.save(category);
    }

    public void deleteExpenseCategory(Long id) {
        expenseCategoryRepository.deleteById(id);
    }

    public ExpenseCategory updateExpenseCategory(Long id, ExpenseCategory expenseCategory) {
        // Recherche de la catégorie de dépenses existante dans la base de données par son ID
        Optional<ExpenseCategory> optionalExpenseCategory = expenseCategoryRepository.findById(id);

        // Vérifier si la catégorie de dépenses existe
        if (optionalExpenseCategory.isPresent()) {
            // Récupérer la catégorie de dépenses existante
            ExpenseCategory existingExpenseCategory = optionalExpenseCategory.get();

            // Mettre à jour les attributs de la catégorie de dépenses existante avec les valeurs fournies
            existingExpenseCategory.setName(expenseCategory.getName());
            existingExpenseCategory.setDescription(expenseCategory.getDescription());

            // Sauvegarder la catégorie de dépenses mise à jour dans la base de données
            return expenseCategoryRepository.save(existingExpenseCategory);
        } else {
            // Si la catégorie de dépenses n'existe pas, vous pouvez gérer l'erreur ici
            throw new NoSuchElementException("Expense category with ID " + id + " not found");
        }
    }
}
