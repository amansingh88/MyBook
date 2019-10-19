package com.example.demo;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    TodoRepository todoRepository;

    @Autowired
    CloudinaryConfig cloudc;


    @RequestMapping("/")
    public String listTodos (Model model){
        model.addAttribute("todos", todoRepository.findAll());
        return "list";
    }

//    @GetMapping("/add")
//    public String todoform(Model model){
//        model.addAttribute("todo", new Todo());
//        return "todoform";
//    }

    @GetMapping("/add")
    public String newTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "todoform";
    }

    @PostMapping("/process")
    public String processform(@Valid Todo todo, BindingResult result){
        if (result.hasErrors()) {
            return "todoform";
        }
        todoRepository.save(todo);
        return "redirect:/";
    }


        @PostMapping("/add")
        public String processTodo(@ModelAttribute Todo todo,
                @RequestParam("file") MultipartFile file){
            if (file.isEmpty()){
                return "redirect:/add";
            }
            try{
                Map uploadResult= cloudc.upload(file.getBytes(),
                        ObjectUtils.asMap("resourcetype", "auto"));
                todo.setHeadshot(uploadResult.get("url").toString());
                todoRepository.save(todo);
            }
            catch (IOException e){
                e.printStackTrace();
                return "redirect:/add";
            }
            return "redirect:/";
        }

//    @RequestMapping("/detail/{id}")
//    public String showTodo(@PathVariable("id") long id, Model model){
//        model.addAttribute("todo", todoRepository.findById(id).get());
//        return  "show";
//    }
//
//    @RequestMapping("/update/{id}")
//    public String updateTodo(@PathVariable("id") long id, Model model){
//        model.addAttribute("todo", todoRepository.findById(id).get());
//        return "todoform";
//    }
//
    @RequestMapping("/delete/{id}")
    public String delTodo(@PathVariable("id") long id){
        todoRepository.deleteById(id);
        return "redirect:/";
    }


}
