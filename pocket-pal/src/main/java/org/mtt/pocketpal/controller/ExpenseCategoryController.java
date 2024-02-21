package org.mtt.pocketpal.controller;

import org.mtt.pocketpal.model.ExpenseCategory;
import org.mtt.pocketpal.model.User;
import org.mtt.pocketpal.service.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expense-categories")
public class ExpenseCategoryController {

    @Autowired
    private ExpenseCategoryService expenseCategoryService;

    @GetMapping
    public List<ExpenseCategory> getAllExpenseCategories() {
        return expenseCategoryService.getAllExpenseCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseCategory> getExpenseCategoryById(@PathVariable Long id) {
        Optional<ExpenseCategory> expenseCategoryOptional = expenseCategoryService.getExpenseCategoryById(id);
        return expenseCategoryOptional.map(expenseCategory -> new ResponseEntity<>(expenseCategory, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ExpenseCategory createExpenseCategory(@RequestBody ExpenseCategory expenseCategory) {
        return expenseCategoryService.createExpenseCategory(expenseCategory);
    }

    @PutMapping("/{id}")
    public ExpenseCategory updateExpenseCategory(@PathVariable Long id, @RequestBody ExpenseCategory expenseCategory) {
        return expenseCategoryService.updateExpenseCategory(id, expenseCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteExpenseCategory(@PathVariable Long id) {
        expenseCategoryService.deleteExpenseCategory(id);
    }
}
