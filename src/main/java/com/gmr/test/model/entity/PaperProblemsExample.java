package com.gmr.test.model.entity;

import java.util.ArrayList;
import java.util.List;

public class PaperProblemsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaperProblemsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andProblemIdIsNull() {
            addCriterion("problem_id is null");
            return (Criteria) this;
        }

        public Criteria andProblemIdIsNotNull() {
            addCriterion("problem_id is not null");
            return (Criteria) this;
        }

        public Criteria andProblemIdEqualTo(Integer value) {
            addCriterion("problem_id =", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdNotEqualTo(Integer value) {
            addCriterion("problem_id <>", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdGreaterThan(Integer value) {
            addCriterion("problem_id >", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("problem_id >=", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdLessThan(Integer value) {
            addCriterion("problem_id <", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdLessThanOrEqualTo(Integer value) {
            addCriterion("problem_id <=", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdIn(List<Integer> values) {
            addCriterion("problem_id in", values, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdNotIn(List<Integer> values) {
            addCriterion("problem_id not in", values, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdBetween(Integer value1, Integer value2) {
            addCriterion("problem_id between", value1, value2, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("problem_id not between", value1, value2, "problemId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNull() {
            addCriterion("paper_id is null");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNotNull() {
            addCriterion("paper_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaperIdEqualTo(Integer value) {
            addCriterion("paper_id =", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotEqualTo(Integer value) {
            addCriterion("paper_id <>", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThan(Integer value) {
            addCriterion("paper_id >", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("paper_id >=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThan(Integer value) {
            addCriterion("paper_id <", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThanOrEqualTo(Integer value) {
            addCriterion("paper_id <=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIn(List<Integer> values) {
            addCriterion("paper_id in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotIn(List<Integer> values) {
            addCriterion("paper_id not in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdBetween(Integer value1, Integer value2) {
            addCriterion("paper_id between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("paper_id not between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andProblemContentIsNull() {
            addCriterion("problem_content is null");
            return (Criteria) this;
        }

        public Criteria andProblemContentIsNotNull() {
            addCriterion("problem_content is not null");
            return (Criteria) this;
        }

        public Criteria andProblemContentEqualTo(String value) {
            addCriterion("problem_content =", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentNotEqualTo(String value) {
            addCriterion("problem_content <>", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentGreaterThan(String value) {
            addCriterion("problem_content >", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentGreaterThanOrEqualTo(String value) {
            addCriterion("problem_content >=", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentLessThan(String value) {
            addCriterion("problem_content <", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentLessThanOrEqualTo(String value) {
            addCriterion("problem_content <=", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentLike(String value) {
            addCriterion("problem_content like", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentNotLike(String value) {
            addCriterion("problem_content not like", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentIn(List<String> values) {
            addCriterion("problem_content in", values, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentNotIn(List<String> values) {
            addCriterion("problem_content not in", values, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentBetween(String value1, String value2) {
            addCriterion("problem_content between", value1, value2, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentNotBetween(String value1, String value2) {
            addCriterion("problem_content not between", value1, value2, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIsNull() {
            addCriterion("problem_type is null");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIsNotNull() {
            addCriterion("problem_type is not null");
            return (Criteria) this;
        }

        public Criteria andProblemTypeEqualTo(Integer value) {
            addCriterion("problem_type =", value, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeNotEqualTo(Integer value) {
            addCriterion("problem_type <>", value, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeGreaterThan(Integer value) {
            addCriterion("problem_type >", value, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("problem_type >=", value, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeLessThan(Integer value) {
            addCriterion("problem_type <", value, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeLessThanOrEqualTo(Integer value) {
            addCriterion("problem_type <=", value, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIn(List<Integer> values) {
            addCriterion("problem_type in", values, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeNotIn(List<Integer> values) {
            addCriterion("problem_type not in", values, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeBetween(Integer value1, Integer value2) {
            addCriterion("problem_type between", value1, value2, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("problem_type not between", value1, value2, "problemType");
            return (Criteria) this;
        }

        public Criteria andQuestionAIsNull() {
            addCriterion("question_a is null");
            return (Criteria) this;
        }

        public Criteria andQuestionAIsNotNull() {
            addCriterion("question_a is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionAEqualTo(String value) {
            addCriterion("question_a =", value, "questionA");
            return (Criteria) this;
        }

        public Criteria andQuestionANotEqualTo(String value) {
            addCriterion("question_a <>", value, "questionA");
            return (Criteria) this;
        }

        public Criteria andQuestionAGreaterThan(String value) {
            addCriterion("question_a >", value, "questionA");
            return (Criteria) this;
        }

        public Criteria andQuestionAGreaterThanOrEqualTo(String value) {
            addCriterion("question_a >=", value, "questionA");
            return (Criteria) this;
        }

        public Criteria andQuestionALessThan(String value) {
            addCriterion("question_a <", value, "questionA");
            return (Criteria) this;
        }

        public Criteria andQuestionALessThanOrEqualTo(String value) {
            addCriterion("question_a <=", value, "questionA");
            return (Criteria) this;
        }

        public Criteria andQuestionALike(String value) {
            addCriterion("question_a like", value, "questionA");
            return (Criteria) this;
        }

        public Criteria andQuestionANotLike(String value) {
            addCriterion("question_a not like", value, "questionA");
            return (Criteria) this;
        }

        public Criteria andQuestionAIn(List<String> values) {
            addCriterion("question_a in", values, "questionA");
            return (Criteria) this;
        }

        public Criteria andQuestionANotIn(List<String> values) {
            addCriterion("question_a not in", values, "questionA");
            return (Criteria) this;
        }

        public Criteria andQuestionABetween(String value1, String value2) {
            addCriterion("question_a between", value1, value2, "questionA");
            return (Criteria) this;
        }

        public Criteria andQuestionANotBetween(String value1, String value2) {
            addCriterion("question_a not between", value1, value2, "questionA");
            return (Criteria) this;
        }

        public Criteria andQuestionBIsNull() {
            addCriterion("question_b is null");
            return (Criteria) this;
        }

        public Criteria andQuestionBIsNotNull() {
            addCriterion("question_b is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionBEqualTo(String value) {
            addCriterion("question_b =", value, "questionB");
            return (Criteria) this;
        }

        public Criteria andQuestionBNotEqualTo(String value) {
            addCriterion("question_b <>", value, "questionB");
            return (Criteria) this;
        }

        public Criteria andQuestionBGreaterThan(String value) {
            addCriterion("question_b >", value, "questionB");
            return (Criteria) this;
        }

        public Criteria andQuestionBGreaterThanOrEqualTo(String value) {
            addCriterion("question_b >=", value, "questionB");
            return (Criteria) this;
        }

        public Criteria andQuestionBLessThan(String value) {
            addCriterion("question_b <", value, "questionB");
            return (Criteria) this;
        }

        public Criteria andQuestionBLessThanOrEqualTo(String value) {
            addCriterion("question_b <=", value, "questionB");
            return (Criteria) this;
        }

        public Criteria andQuestionBLike(String value) {
            addCriterion("question_b like", value, "questionB");
            return (Criteria) this;
        }

        public Criteria andQuestionBNotLike(String value) {
            addCriterion("question_b not like", value, "questionB");
            return (Criteria) this;
        }

        public Criteria andQuestionBIn(List<String> values) {
            addCriterion("question_b in", values, "questionB");
            return (Criteria) this;
        }

        public Criteria andQuestionBNotIn(List<String> values) {
            addCriterion("question_b not in", values, "questionB");
            return (Criteria) this;
        }

        public Criteria andQuestionBBetween(String value1, String value2) {
            addCriterion("question_b between", value1, value2, "questionB");
            return (Criteria) this;
        }

        public Criteria andQuestionBNotBetween(String value1, String value2) {
            addCriterion("question_b not between", value1, value2, "questionB");
            return (Criteria) this;
        }

        public Criteria andQuestionCIsNull() {
            addCriterion("question_c is null");
            return (Criteria) this;
        }

        public Criteria andQuestionCIsNotNull() {
            addCriterion("question_c is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionCEqualTo(String value) {
            addCriterion("question_c =", value, "questionC");
            return (Criteria) this;
        }

        public Criteria andQuestionCNotEqualTo(String value) {
            addCriterion("question_c <>", value, "questionC");
            return (Criteria) this;
        }

        public Criteria andQuestionCGreaterThan(String value) {
            addCriterion("question_c >", value, "questionC");
            return (Criteria) this;
        }

        public Criteria andQuestionCGreaterThanOrEqualTo(String value) {
            addCriterion("question_c >=", value, "questionC");
            return (Criteria) this;
        }

        public Criteria andQuestionCLessThan(String value) {
            addCriterion("question_c <", value, "questionC");
            return (Criteria) this;
        }

        public Criteria andQuestionCLessThanOrEqualTo(String value) {
            addCriterion("question_c <=", value, "questionC");
            return (Criteria) this;
        }

        public Criteria andQuestionCLike(String value) {
            addCriterion("question_c like", value, "questionC");
            return (Criteria) this;
        }

        public Criteria andQuestionCNotLike(String value) {
            addCriterion("question_c not like", value, "questionC");
            return (Criteria) this;
        }

        public Criteria andQuestionCIn(List<String> values) {
            addCriterion("question_c in", values, "questionC");
            return (Criteria) this;
        }

        public Criteria andQuestionCNotIn(List<String> values) {
            addCriterion("question_c not in", values, "questionC");
            return (Criteria) this;
        }

        public Criteria andQuestionCBetween(String value1, String value2) {
            addCriterion("question_c between", value1, value2, "questionC");
            return (Criteria) this;
        }

        public Criteria andQuestionCNotBetween(String value1, String value2) {
            addCriterion("question_c not between", value1, value2, "questionC");
            return (Criteria) this;
        }

        public Criteria andQuestionDIsNull() {
            addCriterion("question_d is null");
            return (Criteria) this;
        }

        public Criteria andQuestionDIsNotNull() {
            addCriterion("question_d is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionDEqualTo(String value) {
            addCriterion("question_d =", value, "questionD");
            return (Criteria) this;
        }

        public Criteria andQuestionDNotEqualTo(String value) {
            addCriterion("question_d <>", value, "questionD");
            return (Criteria) this;
        }

        public Criteria andQuestionDGreaterThan(String value) {
            addCriterion("question_d >", value, "questionD");
            return (Criteria) this;
        }

        public Criteria andQuestionDGreaterThanOrEqualTo(String value) {
            addCriterion("question_d >=", value, "questionD");
            return (Criteria) this;
        }

        public Criteria andQuestionDLessThan(String value) {
            addCriterion("question_d <", value, "questionD");
            return (Criteria) this;
        }

        public Criteria andQuestionDLessThanOrEqualTo(String value) {
            addCriterion("question_d <=", value, "questionD");
            return (Criteria) this;
        }

        public Criteria andQuestionDLike(String value) {
            addCriterion("question_d like", value, "questionD");
            return (Criteria) this;
        }

        public Criteria andQuestionDNotLike(String value) {
            addCriterion("question_d not like", value, "questionD");
            return (Criteria) this;
        }

        public Criteria andQuestionDIn(List<String> values) {
            addCriterion("question_d in", values, "questionD");
            return (Criteria) this;
        }

        public Criteria andQuestionDNotIn(List<String> values) {
            addCriterion("question_d not in", values, "questionD");
            return (Criteria) this;
        }

        public Criteria andQuestionDBetween(String value1, String value2) {
            addCriterion("question_d between", value1, value2, "questionD");
            return (Criteria) this;
        }

        public Criteria andQuestionDNotBetween(String value1, String value2) {
            addCriterion("question_d not between", value1, value2, "questionD");
            return (Criteria) this;
        }

        public Criteria andRightAnswerIsNull() {
            addCriterion("right_answer is null");
            return (Criteria) this;
        }

        public Criteria andRightAnswerIsNotNull() {
            addCriterion("right_answer is not null");
            return (Criteria) this;
        }

        public Criteria andRightAnswerEqualTo(String value) {
            addCriterion("right_answer =", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerNotEqualTo(String value) {
            addCriterion("right_answer <>", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerGreaterThan(String value) {
            addCriterion("right_answer >", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("right_answer >=", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerLessThan(String value) {
            addCriterion("right_answer <", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerLessThanOrEqualTo(String value) {
            addCriterion("right_answer <=", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerLike(String value) {
            addCriterion("right_answer like", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerNotLike(String value) {
            addCriterion("right_answer not like", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerIn(List<String> values) {
            addCriterion("right_answer in", values, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerNotIn(List<String> values) {
            addCriterion("right_answer not in", values, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerBetween(String value1, String value2) {
            addCriterion("right_answer between", value1, value2, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerNotBetween(String value1, String value2) {
            addCriterion("right_answer not between", value1, value2, "rightAnswer");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}