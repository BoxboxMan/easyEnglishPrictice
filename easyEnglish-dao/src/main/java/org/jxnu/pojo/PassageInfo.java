package org.jxnu.pojo;

public class PassageInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column passage_info.id
     *
     * @mbggenerated Tue Dec 04 15:05:36 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column passage_info.passage
     *
     * @mbggenerated Tue Dec 04 15:05:36 CST 2018
     */
    private String passage;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column passage_info.id
     *
     * @return the value of passage_info.id
     *
     * @mbggenerated Tue Dec 04 15:05:36 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column passage_info.id
     *
     * @param id the value for passage_info.id
     *
     * @mbggenerated Tue Dec 04 15:05:36 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column passage_info.passage
     *
     * @return the value of passage_info.passage
     *
     * @mbggenerated Tue Dec 04 15:05:36 CST 2018
     */
    public String getPassage() {
        return passage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column passage_info.passage
     *
     * @param passage the value for passage_info.passage
     *
     * @mbggenerated Tue Dec 04 15:05:36 CST 2018
     */
    public void setPassage(String passage) {
        this.passage = passage == null ? null : passage.trim();
    }
}