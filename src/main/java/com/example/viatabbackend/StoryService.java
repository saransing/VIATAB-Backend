package com.example.viatabbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoryService {

    private final StoryRepository storyRepository;

    @Autowired
    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public List<Story> getAllStories() {
        return storyRepository.findAll();
    }

    public Optional<Story> getStoryById(Long id) {
        return storyRepository.findById(id);
    }

    public List<Story> getStoriesByDepartment(String department) {
        return storyRepository.findByDepartment(department);
    }

    public Story addStory(Story story) {
        return storyRepository.save(story);
    }

    public Optional<Story> updateStory(Long id, Story updatedStory) {
        Optional<Story> optionalStory = storyRepository.findById(id);

        if (optionalStory.isPresent()) {
            Story story = optionalStory.get();
            story.setTitle(updatedStory.getTitle());
            story.setContent(updatedStory.getContent());
            story.setDepartment(updatedStory.getDepartment());
            return Optional.of(storyRepository.save(story));
        }
        return Optional.empty();
    }

    public boolean deleteStory(Long id) {
        if (storyRepository.existsById(id)) {
            storyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
