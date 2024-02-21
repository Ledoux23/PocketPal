package org.mtt.pocketpal.service;

import org.mtt.pocketpal.model.Tag;
import org.mtt.pocketpal.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Optional<Tag> getTagById(Long id) {
        return tagRepository.findById(id);
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    public Tag updateTag(Long id, Tag tag) {
        // Recherche de la balise existante dans la base de données par son ID
        Optional<Tag> optionalTag = tagRepository.findById(id);

        // Vérifier si la balise existe
        if (optionalTag.isPresent()) {
            // Récupérer la balise existante
            Tag existingTag = optionalTag.get();

            // Mettre à jour les attributs de la balise existante avec les valeurs fournies
            existingTag.setLabel(tag.getLabel());

            // Sauvegarder la balise mise à jour dans la base de données
            return tagRepository.save(existingTag);
        } else {
            // Si la balise n'existe pas, vous pouvez gérer l'erreur ici
            throw new NoSuchElementException("Tag with ID " + id + " not found");
        }
    }
}
