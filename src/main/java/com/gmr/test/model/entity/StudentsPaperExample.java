package com.gmr.test.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentsPaperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentsPaperExample() {
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

        public Criteria andStudentsPaperIdIsNull() {
            addCriterion("students_paper_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentsPaperIdIsNotNull() {
            addCriterion("students_paper_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentsPaperIdEqualTo(Integer value) {
            addCriterion("students_paper_id =", value, "studentsPaperId");
            return (Criteria) this;
        }

        public Criteria andStudentsPaperIdNotEqualTo(Integer value) {
            addCriterion("students_paper_id <>", value, "studentsPaperId");
            return (Criteria) this;
        }

        public Criteria andStudentsPaperIdGreaterThan(Integer value) {
            addCriterion("students_paper_id >", value, "studentsPaperId");
            return (Criteria) this;
        }

        public Criteria andStudentsPaperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("students_paper_id >=", value, "studentsPaperId");
            return (Criteria) this;
        }

        public Criteria andStudentsPaperIdLessThan(Integer value) {
            addCriterion("students_paper_id <", value, "studentsPaperId");
            return (Criteria) this;
        }

        public Criteria andStudentsPaperIdLessThanOrEqualTo(Integer value) {
            addCriterion("students_paper_id <=", value, "studentsPaperId");
            return (Criteria) this;
        }

        public Criteria andStudentsPaperIdIn(List<Integer> values) {
            addCriterion("students_paper_id in", values, "studentsPaperId");
            return (Criteria) this;
        }

        public Criteria andStudentsPaperIdNotIn(List<Integer> values) {
            addCriterion("students_paper_id not in", values, "studentsPaperId");
            return (Criteria) this;
        }

        public Criteria andStudentsPaperIdBetween(Integer value1, Integer value2) {
            addCriterion("students_paper_id between", value1, value2, "studentsPaperId");
            return (Criteria) this;
        }

        public Criteria andStudentsPaperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("students_paper_id not between", value1, value2, "studentsPaperId");
            return (Criteria) this;
        }

        public Criteria andPapperIdIsNull() {
            addCriterion("papper_id is null");
            return (Criteria) this;
        }

        public Criteria andPapperIdIsNotNull() {
            addCriterion("papper_id is not null");
            return (Criteria) this;
        }

        public Criteria andPapperIdEqualTo(Integer value) {
            addCriterion("papper_id =", value, "papperId");
            return (Criteria) this;
        }

        public Criteria andPapperIdNotEqualTo(Integer value) {
            addCriterion("papper_id <>", value, "papperId");
            return (Criteria) this;
        }

        public Criteria andPapperIdGreaterThan(Integer value) {
            addCriterion("papper_id >", value, "papperId");
            return (Criteria) this;
        }

        public Criteria andPapperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("papper_id >=", value, "papperId");
            return (Criteria) this;
        }

        public Criteria andPapperIdLessThan(Integer value) {
            addCriterion("papper_id <", value, "papperId");
            return (Criteria) this;
        }

        public Criteria andPapperIdLessThanOrEqualTo(Integer value) {
            addCriterion("papper_id <=", value, "papperId");
            return (Criteria) this;
        }

        public Criteria andPapperIdIn(List<Integer> values) {
            addCriterion("papper_id in", values, "papperId");
            return (Criteria) this;
        }

        public Criteria andPapperIdNotIn(List<Integer> values) {
            addCriterion("papper_id not in", values, "papperId");
            return (Criteria) this;
        }

        public Criteria andPapperIdBetween(Integer value1, Integer value2) {
            addCriterion("papper_id between", value1, value2, "papperId");
            return (Criteria) this;
        }

        public Criteria andPapperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("papper_id not between", value1, value2, "papperId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(String value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(String value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(String value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(String value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(String value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(String value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLike(String value) {
            addCriterion("student_id like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotLike(String value) {
            addCriterion("student_id not like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<String> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<String> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(String value1, String value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(String value1, String value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNull() {
            addCriterion("student_name is null");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNotNull() {
            addCriterion("student_name is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNameEqualTo(String value) {
            addCriterion("student_name =", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotEqualTo(String value) {
            addCriterion("student_name <>", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThan(String value) {
            addCriterion("student_name >", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThanOrEqualTo(String value) {
            addCriterion("student_name >=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThan(String value) {
            addCriterion("student_name <", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThanOrEqualTo(String value) {
            addCriterion("student_name <=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLike(String value) {
            addCriterion("student_name like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotLike(String value) {
            addCriterion("student_name not like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameIn(List<String> values) {
            addCriterion("student_name in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotIn(List<String> values) {
            addCriterion("student_name not in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameBetween(String value1, String value2) {
            addCriterion("student_name between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotBetween(String value1, String value2) {
            addCriterion("student_name not between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentScoreIsNull() {
            addCriterion("student_score is null");
            return (Criteria) this;
        }

        public Criteria andStudentScoreIsNotNull() {
            addCriterion("student_score is not null");
            return (Criteria) this;
        }

        public Criteria andStudentScoreEqualTo(Integer value) {
            addCriterion("student_score =", value, "studentScore");
            return (Criteria) this;
        }

        public Criteria andStudentScoreNotEqualTo(Integer value) {
            addCriterion("student_score <>", value, "studentScore");
            return (Criteria) this;
        }

        public Criteria andStudentScoreGreaterThan(Integer value) {
            addCriterion("student_score >", value, "studentScore");
            return (Criteria) this;
        }

        public Criteria andStudentScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("student_score >=", value, "studentScore");
            return (Criteria) this;
        }

        public Criteria andStudentScoreLessThan(Integer value) {
            addCriterion("student_score <", value, "studentScore");
            return (Criteria) this;
        }

        public Criteria andStudentScoreLessThanOrEqualTo(Integer value) {
            addCriterion("student_score <=", value, "studentScore");
            return (Criteria) this;
        }

        public Criteria andStudentScoreIn(List<Integer> values) {
            addCriterion("student_score in", values, "studentScore");
            return (Criteria) this;
        }

        public Criteria andStudentScoreNotIn(List<Integer> values) {
            addCriterion("student_score not in", values, "studentScore");
            return (Criteria) this;
        }

        public Criteria andStudentScoreBetween(Integer value1, Integer value2) {
            addCriterion("student_score between", value1, value2, "studentScore");
            return (Criteria) this;
        }

        public Criteria andStudentScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("student_score not between", value1, value2, "studentScore");
            return (Criteria) this;
        }

        public Criteria andCorrectRateIsNull() {
            addCriterion("correct_rate is null");
            return (Criteria) this;
        }

        public Criteria andCorrectRateIsNotNull() {
            addCriterion("correct_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCorrectRateEqualTo(String value) {
            addCriterion("correct_rate =", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateNotEqualTo(String value) {
            addCriterion("correct_rate <>", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateGreaterThan(String value) {
            addCriterion("correct_rate >", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateGreaterThanOrEqualTo(String value) {
            addCriterion("correct_rate >=", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateLessThan(String value) {
            addCriterion("correct_rate <", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateLessThanOrEqualTo(String value) {
            addCriterion("correct_rate <=", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateLike(String value) {
            addCriterion("correct_rate like", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateNotLike(String value) {
            addCriterion("correct_rate not like", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateIn(List<String> values) {
            addCriterion("correct_rate in", values, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateNotIn(List<String> values) {
            addCriterion("correct_rate not in", values, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateBetween(String value1, String value2) {
            addCriterion("correct_rate between", value1, value2, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateNotBetween(String value1, String value2) {
            addCriterion("correct_rate not between", value1, value2, "correctRate");
            return (Criteria) this;
        }

        public Criteria andIsSubmitIsNull() {
            addCriterion("is_submit is null");
            return (Criteria) this;
        }

        public Criteria andIsSubmitIsNotNull() {
            addCriterion("is_submit is not null");
            return (Criteria) this;
        }

        public Criteria andIsSubmitEqualTo(Integer value) {
            addCriterion("is_submit =", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitNotEqualTo(Integer value) {
            addCriterion("is_submit <>", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitGreaterThan(Integer value) {
            addCriterion("is_submit >", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_submit >=", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitLessThan(Integer value) {
            addCriterion("is_submit <", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitLessThanOrEqualTo(Integer value) {
            addCriterion("is_submit <=", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitIn(List<Integer> values) {
            addCriterion("is_submit in", values, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitNotIn(List<Integer> values) {
            addCriterion("is_submit not in", values, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitBetween(Integer value1, Integer value2) {
            addCriterion("is_submit between", value1, value2, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitNotBetween(Integer value1, Integer value2) {
            addCriterion("is_submit not between", value1, value2, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNull() {
            addCriterion("submit_time is null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNotNull() {
            addCriterion("submit_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeEqualTo(Date value) {
            addCriterion("submit_time =", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotEqualTo(Date value) {
            addCriterion("submit_time <>", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThan(Date value) {
            addCriterion("submit_time >", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submit_time >=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThan(Date value) {
            addCriterion("submit_time <", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThanOrEqualTo(Date value) {
            addCriterion("submit_time <=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIn(List<Date> values) {
            addCriterion("submit_time in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotIn(List<Date> values) {
            addCriterion("submit_time not in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeBetween(Date value1, Date value2) {
            addCriterion("submit_time between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotBetween(Date value1, Date value2) {
            addCriterion("submit_time not between", value1, value2, "submitTime");
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