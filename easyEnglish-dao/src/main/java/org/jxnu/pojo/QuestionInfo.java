package org.jxnu.pojo;

public class QuestionInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question_info.id
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question_info.question
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    private String question;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question_info.answer
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    private String answer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question_info.score
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    private Integer score;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question_info.anno
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    private String anno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question_info.type
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    private Integer type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question_info.id
     *
     * @return the value of question_info.id
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question_info.id
     *
     * @param id the value for question_info.id
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question_info.question
     *
     * @return the value of question_info.question
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    public String getQuestion() {
        return question;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question_info.question
     *
     * @param question the value for question_info.question
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question_info.answer
     *
     * @return the value of question_info.answer
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question_info.answer
     *
     * @param answer the value for question_info.answer
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question_info.score
     *
     * @return the value of question_info.score
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    public Integer getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question_info.score
     *
     * @param score the value for question_info.score
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question_info.anno
     *
     * @return the value of question_info.anno
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    public String getAnno() {
        return anno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question_info.anno
     *
     * @param anno the value for question_info.anno
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    public void setAnno(String anno) {
        this.anno = anno == null ? null : anno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question_info.type
     *
     * @return the value of question_info.type
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question_info.type
     *
     * @param type the value for question_info.type
     *
     * @mbggenerated Sun Nov 25 16:35:56 CST 2018
     */
    public void setType(Integer type) {
        this.type = type;
    }
}