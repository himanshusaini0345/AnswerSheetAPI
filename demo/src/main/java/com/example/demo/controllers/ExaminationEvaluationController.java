package com.example.demo.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ExaminationEvaluator.Question;
import ExaminationEvaluator.QuestionPaper;
import ExaminationEvaluator.AnswerSheet;
import ExaminationEvaluator.Evaluator;

@RestController
public class ExaminationEvaluationController {

    @GetMapping("/test-sheet")
    public String testAnswerSheet() {
        Question q1 = new Question("Explain OOP", 10);

        Question q2 = new Question("Algorithms", List.of(
                new Question("Sorting", 5),
                new Question("Searching", 5)
        ), null);

        Question q3 = new Question("Attempt any 2", List.of(
                new Question("Short Q1", 2),
                new Question("Short Q2", 2),
                new Question("Short Q3", 2)
        ), 2);

        QuestionPaper paper = new QuestionPaper(101, "OOP Midterm", 25, "");
        paper.addQuestion(q1);
        paper.addQuestion(q2);
        paper.addQuestion(q3);

        AnswerSheet sheet = new AnswerSheet(1, "Alice", paper,4);
        Evaluator evaluator = new Evaluator("Jim");

        // Assign marks to only leaf questions
        evaluator.assignMarks(sheet, q1, 8, 1, 10 , 20);
        evaluator.assignMarks(sheet, q2.getSubQuestions().get(0), 4, 2, 5,8);
        evaluator.assignMarks(sheet, q2.getSubQuestions().get(1), 5, 2, 1,5);
        evaluator.assignMarks(sheet, q3.getSubQuestions().get(2), 1,3,20,30);
        evaluator.assignMarks(sheet, q3.getSubQuestions().get(0), 2,3,45,67);
        evaluator.assignMarks(sheet, q3.getSubQuestions().get(1), 2,4,21,43);
        
        return "Total Marks: " + sheet.getTotalObtainedMarks();
    }
}
