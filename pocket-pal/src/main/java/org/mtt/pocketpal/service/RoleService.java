package org.mtt.pocketpal.service;

import org.mtt.pocketpal.model.Role;
import org.mtt.pocketpal.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    public Role updateRole(Long id, Role role) {
        // Recherche du rôle existant dans la base de données par son ID
        Optional<Role> optionalRole = roleRepository.findById(id);

        // Vérifier si le rôle existe
        if (optionalRole.isPresent()) {
            // Récupérer le rôle existant
            Role existingRole = optionalRole.get();

            // Mettre à jour les attributs du rôle existant avec les valeurs fournies
            existingRole.setName(role.getName());

            // Sauvegarder le rôle mis à jour dans la base de données
            return roleRepository.save(existingRole);
        } else {
            // Si le rôle n'existe pas, vous pouvez gérer l'erreur ici
            throw new NoSuchElementException("Role with ID " + id + " not found");
        }
    }
}
