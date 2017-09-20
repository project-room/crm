package com.crm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserTaskExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNull() {
            addCriterion("task_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(Integer value) {
            addCriterion("task_status =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(Integer value) {
            addCriterion("task_status <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(Integer value) {
            addCriterion("task_status >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_status >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(Integer value) {
            addCriterion("task_status <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(Integer value) {
            addCriterion("task_status <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<Integer> values) {
            addCriterion("task_status in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<Integer> values) {
            addCriterion("task_status not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(Integer value1, Integer value2) {
            addCriterion("task_status between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("task_status not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNull() {
            addCriterion("task_content is null");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNotNull() {
            addCriterion("task_content is not null");
            return (Criteria) this;
        }

        public Criteria andTaskContentEqualTo(String value) {
            addCriterion("task_content =", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotEqualTo(String value) {
            addCriterion("task_content <>", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThan(String value) {
            addCriterion("task_content >", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThanOrEqualTo(String value) {
            addCriterion("task_content >=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThan(String value) {
            addCriterion("task_content <", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThanOrEqualTo(String value) {
            addCriterion("task_content <=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLike(String value) {
            addCriterion("task_content like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotLike(String value) {
            addCriterion("task_content not like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentIn(List<String> values) {
            addCriterion("task_content in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotIn(List<String> values) {
            addCriterion("task_content not in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentBetween(String value1, String value2) {
            addCriterion("task_content between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotBetween(String value1, String value2) {
            addCriterion("task_content not between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskDateIsNull() {
            addCriterion("task_date is null");
            return (Criteria) this;
        }

        public Criteria andTaskDateIsNotNull() {
            addCriterion("task_date is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDateEqualTo(Date value) {
            addCriterion("task_date =", value, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateNotEqualTo(Date value) {
            addCriterion("task_date <>", value, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateGreaterThan(Date value) {
            addCriterion("task_date >", value, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateGreaterThanOrEqualTo(Date value) {
            addCriterion("task_date >=", value, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateLessThan(Date value) {
            addCriterion("task_date <", value, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateLessThanOrEqualTo(Date value) {
            addCriterion("task_date <=", value, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateIn(List<Date> values) {
            addCriterion("task_date in", values, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateNotIn(List<Date> values) {
            addCriterion("task_date not in", values, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateBetween(Date value1, Date value2) {
            addCriterion("task_date between", value1, value2, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateNotBetween(Date value1, Date value2) {
            addCriterion("task_date not between", value1, value2, "taskDate");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCstIdIsNull() {
            addCriterion("cst_id is null");
            return (Criteria) this;
        }

        public Criteria andCstIdIsNotNull() {
            addCriterion("cst_id is not null");
            return (Criteria) this;
        }

        public Criteria andCstIdEqualTo(Long value) {
            addCriterion("cst_id =", value, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdNotEqualTo(Long value) {
            addCriterion("cst_id <>", value, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdGreaterThan(Long value) {
            addCriterion("cst_id >", value, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cst_id >=", value, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdLessThan(Long value) {
            addCriterion("cst_id <", value, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdLessThanOrEqualTo(Long value) {
            addCriterion("cst_id <=", value, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdIn(List<Long> values) {
            addCriterion("cst_id in", values, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdNotIn(List<Long> values) {
            addCriterion("cst_id not in", values, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdBetween(Long value1, Long value2) {
            addCriterion("cst_id between", value1, value2, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdNotBetween(Long value1, Long value2) {
            addCriterion("cst_id not between", value1, value2, "cstId");
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