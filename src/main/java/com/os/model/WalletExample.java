package com.os.model;

import java.util.ArrayList;
import java.util.List;

public class WalletExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WalletExample() {
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

        public Criteria andOsIdIsNull() {
            addCriterion("os_id is null");
            return (Criteria) this;
        }

        public Criteria andOsIdIsNotNull() {
            addCriterion("os_id is not null");
            return (Criteria) this;
        }

        public Criteria andOsIdEqualTo(Long value) {
            addCriterion("os_id =", value, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdNotEqualTo(Long value) {
            addCriterion("os_id <>", value, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdGreaterThan(Long value) {
            addCriterion("os_id >", value, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("os_id >=", value, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdLessThan(Long value) {
            addCriterion("os_id <", value, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdLessThanOrEqualTo(Long value) {
            addCriterion("os_id <=", value, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdIn(List<Long> values) {
            addCriterion("os_id in", values, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdNotIn(List<Long> values) {
            addCriterion("os_id not in", values, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdBetween(Long value1, Long value2) {
            addCriterion("os_id between", value1, value2, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdNotBetween(Long value1, Long value2) {
            addCriterion("os_id not between", value1, value2, "osId");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(Double value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(Double value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(Double value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(Double value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(Double value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<Double> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<Double> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(Double value1, Double value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(Double value1, Double value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andAlipayNameIsNull() {
            addCriterion("alipay_name is null");
            return (Criteria) this;
        }

        public Criteria andAlipayNameIsNotNull() {
            addCriterion("alipay_name is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayNameEqualTo(String value) {
            addCriterion("alipay_name =", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameNotEqualTo(String value) {
            addCriterion("alipay_name <>", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameGreaterThan(String value) {
            addCriterion("alipay_name >", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_name >=", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameLessThan(String value) {
            addCriterion("alipay_name <", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameLessThanOrEqualTo(String value) {
            addCriterion("alipay_name <=", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameLike(String value) {
            addCriterion("alipay_name like", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameNotLike(String value) {
            addCriterion("alipay_name not like", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameIn(List<String> values) {
            addCriterion("alipay_name in", values, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameNotIn(List<String> values) {
            addCriterion("alipay_name not in", values, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameBetween(String value1, String value2) {
            addCriterion("alipay_name between", value1, value2, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameNotBetween(String value1, String value2) {
            addCriterion("alipay_name not between", value1, value2, "alipayName");
            return (Criteria) this;
        }

        public Criteria andWxpayNameIsNull() {
            addCriterion("wxpay_name is null");
            return (Criteria) this;
        }

        public Criteria andWxpayNameIsNotNull() {
            addCriterion("wxpay_name is not null");
            return (Criteria) this;
        }

        public Criteria andWxpayNameEqualTo(String value) {
            addCriterion("wxpay_name =", value, "wxpayName");
            return (Criteria) this;
        }

        public Criteria andWxpayNameNotEqualTo(String value) {
            addCriterion("wxpay_name <>", value, "wxpayName");
            return (Criteria) this;
        }

        public Criteria andWxpayNameGreaterThan(String value) {
            addCriterion("wxpay_name >", value, "wxpayName");
            return (Criteria) this;
        }

        public Criteria andWxpayNameGreaterThanOrEqualTo(String value) {
            addCriterion("wxpay_name >=", value, "wxpayName");
            return (Criteria) this;
        }

        public Criteria andWxpayNameLessThan(String value) {
            addCriterion("wxpay_name <", value, "wxpayName");
            return (Criteria) this;
        }

        public Criteria andWxpayNameLessThanOrEqualTo(String value) {
            addCriterion("wxpay_name <=", value, "wxpayName");
            return (Criteria) this;
        }

        public Criteria andWxpayNameLike(String value) {
            addCriterion("wxpay_name like", value, "wxpayName");
            return (Criteria) this;
        }

        public Criteria andWxpayNameNotLike(String value) {
            addCriterion("wxpay_name not like", value, "wxpayName");
            return (Criteria) this;
        }

        public Criteria andWxpayNameIn(List<String> values) {
            addCriterion("wxpay_name in", values, "wxpayName");
            return (Criteria) this;
        }

        public Criteria andWxpayNameNotIn(List<String> values) {
            addCriterion("wxpay_name not in", values, "wxpayName");
            return (Criteria) this;
        }

        public Criteria andWxpayNameBetween(String value1, String value2) {
            addCriterion("wxpay_name between", value1, value2, "wxpayName");
            return (Criteria) this;
        }

        public Criteria andWxpayNameNotBetween(String value1, String value2) {
            addCriterion("wxpay_name not between", value1, value2, "wxpayName");
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