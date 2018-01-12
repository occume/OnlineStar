package com.os.model;

import java.util.ArrayList;
import java.util.List;

public class WalletBankcardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WalletBankcardExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andauthIdIsNull() {
            addCriterion("auth_id is null");
            return (Criteria) this;
        }

        public Criteria andauthIdIsNotNull() {
            addCriterion("auth_id is not null");
            return (Criteria) this;
        }

        public Criteria andauthIdEqualTo(Long value) {
            addCriterion("auth_id =", value, "authId");
            return (Criteria) this;
        }

        public Criteria andauthIdNotEqualTo(Long value) {
            addCriterion("auth_id <>", value, "authId");
            return (Criteria) this;
        }

        public Criteria andauthIdGreaterThan(Long value) {
            addCriterion("auth_id >", value, "authId");
            return (Criteria) this;
        }

        public Criteria andauthIdGreaterThanOrEqualTo(Long value) {
            addCriterion("auth_id >=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andauthIdLessThan(Long value) {
            addCriterion("auth_id <", value, "authId");
            return (Criteria) this;
        }

        public Criteria andauthIdLessThanOrEqualTo(Long value) {
            addCriterion("auth_id <=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andauthIdIn(List<Long> values) {
            addCriterion("auth_id in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andauthIdNotIn(List<Long> values) {
            addCriterion("auth_id not in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andauthIdBetween(Long value1, Long value2) {
            addCriterion("auth_id between", value1, value2, "authId");
            return (Criteria) this;
        }

        public Criteria andauthIdNotBetween(Long value1, Long value2) {
            addCriterion("auth_id not between", value1, value2, "authId");
            return (Criteria) this;
        }

        public Criteria andCardTypeIdIsNull() {
            addCriterion("card_type_id is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIdIsNotNull() {
            addCriterion("card_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIdEqualTo(Integer value) {
            addCriterion("card_type_id =", value, "cardTypeId");
            return (Criteria) this;
        }

        public Criteria andCardTypeIdNotEqualTo(Integer value) {
            addCriterion("card_type_id <>", value, "cardTypeId");
            return (Criteria) this;
        }

        public Criteria andCardTypeIdGreaterThan(Integer value) {
            addCriterion("card_type_id >", value, "cardTypeId");
            return (Criteria) this;
        }

        public Criteria andCardTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_type_id >=", value, "cardTypeId");
            return (Criteria) this;
        }

        public Criteria andCardTypeIdLessThan(Integer value) {
            addCriterion("card_type_id <", value, "cardTypeId");
            return (Criteria) this;
        }

        public Criteria andCardTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("card_type_id <=", value, "cardTypeId");
            return (Criteria) this;
        }

        public Criteria andCardTypeIdIn(List<Integer> values) {
            addCriterion("card_type_id in", values, "cardTypeId");
            return (Criteria) this;
        }

        public Criteria andCardTypeIdNotIn(List<Integer> values) {
            addCriterion("card_type_id not in", values, "cardTypeId");
            return (Criteria) this;
        }

        public Criteria andCardTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("card_type_id between", value1, value2, "cardTypeId");
            return (Criteria) this;
        }

        public Criteria andCardTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("card_type_id not between", value1, value2, "cardTypeId");
            return (Criteria) this;
        }

        public Criteria andCardOwnerIsNull() {
            addCriterion("card_owner is null");
            return (Criteria) this;
        }

        public Criteria andCardOwnerIsNotNull() {
            addCriterion("card_owner is not null");
            return (Criteria) this;
        }

        public Criteria andCardOwnerEqualTo(String value) {
            addCriterion("card_owner =", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerNotEqualTo(String value) {
            addCriterion("card_owner <>", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerGreaterThan(String value) {
            addCriterion("card_owner >", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("card_owner >=", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerLessThan(String value) {
            addCriterion("card_owner <", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerLessThanOrEqualTo(String value) {
            addCriterion("card_owner <=", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerLike(String value) {
            addCriterion("card_owner like", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerNotLike(String value) {
            addCriterion("card_owner not like", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerIn(List<String> values) {
            addCriterion("card_owner in", values, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerNotIn(List<String> values) {
            addCriterion("card_owner not in", values, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerBetween(String value1, String value2) {
            addCriterion("card_owner between", value1, value2, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerNotBetween(String value1, String value2) {
            addCriterion("card_owner not between", value1, value2, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andDefaultIdIsNull() {
            addCriterion("default_id is null");
            return (Criteria) this;
        }

        public Criteria andDefaultIdIsNotNull() {
            addCriterion("default_id is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultIdEqualTo(Integer value) {
            addCriterion("default_id =", value, "defaultId");
            return (Criteria) this;
        }

        public Criteria andDefaultIdNotEqualTo(Integer value) {
            addCriterion("default_id <>", value, "defaultId");
            return (Criteria) this;
        }

        public Criteria andDefaultIdGreaterThan(Integer value) {
            addCriterion("default_id >", value, "defaultId");
            return (Criteria) this;
        }

        public Criteria andDefaultIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("default_id >=", value, "defaultId");
            return (Criteria) this;
        }

        public Criteria andDefaultIdLessThan(Integer value) {
            addCriterion("default_id <", value, "defaultId");
            return (Criteria) this;
        }

        public Criteria andDefaultIdLessThanOrEqualTo(Integer value) {
            addCriterion("default_id <=", value, "defaultId");
            return (Criteria) this;
        }

        public Criteria andDefaultIdIn(List<Integer> values) {
            addCriterion("default_id in", values, "defaultId");
            return (Criteria) this;
        }

        public Criteria andDefaultIdNotIn(List<Integer> values) {
            addCriterion("default_id not in", values, "defaultId");
            return (Criteria) this;
        }

        public Criteria andDefaultIdBetween(Integer value1, Integer value2) {
            addCriterion("default_id between", value1, value2, "defaultId");
            return (Criteria) this;
        }

        public Criteria andDefaultIdNotBetween(Integer value1, Integer value2) {
            addCriterion("default_id not between", value1, value2, "defaultId");
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