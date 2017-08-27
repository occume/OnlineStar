package com.os.model;

import java.util.ArrayList;
import java.util.List;

public class OnlineStarExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OnlineStarExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAuthIdIsNull() {
            addCriterion("auth_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthIdIsNotNull() {
            addCriterion("auth_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthIdEqualTo(Long value) {
            addCriterion("auth_id =", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotEqualTo(Long value) {
            addCriterion("auth_id <>", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdGreaterThan(Long value) {
            addCriterion("auth_id >", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdGreaterThanOrEqualTo(Long value) {
            addCriterion("auth_id >=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdLessThan(Long value) {
            addCriterion("auth_id <", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdLessThanOrEqualTo(Long value) {
            addCriterion("auth_id <=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdIn(List<Long> values) {
            addCriterion("auth_id in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotIn(List<Long> values) {
            addCriterion("auth_id not in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdBetween(Long value1, Long value2) {
            addCriterion("auth_id between", value1, value2, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotBetween(Long value1, Long value2) {
            addCriterion("auth_id not between", value1, value2, "authId");
            return (Criteria) this;
        }

        public Criteria andOnlineLivePriceIsNull() {
            addCriterion("online_live_price is null");
            return (Criteria) this;
        }

        public Criteria andOnlineLivePriceIsNotNull() {
            addCriterion("online_live_price is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineLivePriceEqualTo(Float value) {
            addCriterion("online_live_price =", value, "onlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOnlineLivePriceNotEqualTo(Float value) {
            addCriterion("online_live_price <>", value, "onlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOnlineLivePriceGreaterThan(Float value) {
            addCriterion("online_live_price >", value, "onlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOnlineLivePriceGreaterThanOrEqualTo(Float value) {
            addCriterion("online_live_price >=", value, "onlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOnlineLivePriceLessThan(Float value) {
            addCriterion("online_live_price <", value, "onlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOnlineLivePriceLessThanOrEqualTo(Float value) {
            addCriterion("online_live_price <=", value, "onlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOnlineLivePriceIn(List<Float> values) {
            addCriterion("online_live_price in", values, "onlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOnlineLivePriceNotIn(List<Float> values) {
            addCriterion("online_live_price not in", values, "onlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOnlineLivePriceBetween(Float value1, Float value2) {
            addCriterion("online_live_price between", value1, value2, "onlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOnlineLivePriceNotBetween(Float value1, Float value2) {
            addCriterion("online_live_price not between", value1, value2, "onlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOfflineLivePriceIsNull() {
            addCriterion("offline_live_price is null");
            return (Criteria) this;
        }

        public Criteria andOfflineLivePriceIsNotNull() {
            addCriterion("offline_live_price is not null");
            return (Criteria) this;
        }

        public Criteria andOfflineLivePriceEqualTo(Float value) {
            addCriterion("offline_live_price =", value, "offlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOfflineLivePriceNotEqualTo(Float value) {
            addCriterion("offline_live_price <>", value, "offlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOfflineLivePriceGreaterThan(Float value) {
            addCriterion("offline_live_price >", value, "offlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOfflineLivePriceGreaterThanOrEqualTo(Float value) {
            addCriterion("offline_live_price >=", value, "offlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOfflineLivePriceLessThan(Float value) {
            addCriterion("offline_live_price <", value, "offlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOfflineLivePriceLessThanOrEqualTo(Float value) {
            addCriterion("offline_live_price <=", value, "offlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOfflineLivePriceIn(List<Float> values) {
            addCriterion("offline_live_price in", values, "offlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOfflineLivePriceNotIn(List<Float> values) {
            addCriterion("offline_live_price not in", values, "offlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOfflineLivePriceBetween(Float value1, Float value2) {
            addCriterion("offline_live_price between", value1, value2, "offlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andOfflineLivePriceNotBetween(Float value1, Float value2) {
            addCriterion("offline_live_price not between", value1, value2, "offlineLivePrice");
            return (Criteria) this;
        }

        public Criteria andBrandSpokePriceIsNull() {
            addCriterion("brand_spoke_price is null");
            return (Criteria) this;
        }

        public Criteria andBrandSpokePriceIsNotNull() {
            addCriterion("brand_spoke_price is not null");
            return (Criteria) this;
        }

        public Criteria andBrandSpokePriceEqualTo(Float value) {
            addCriterion("brand_spoke_price =", value, "brandSpokePrice");
            return (Criteria) this;
        }

        public Criteria andBrandSpokePriceNotEqualTo(Float value) {
            addCriterion("brand_spoke_price <>", value, "brandSpokePrice");
            return (Criteria) this;
        }

        public Criteria andBrandSpokePriceGreaterThan(Float value) {
            addCriterion("brand_spoke_price >", value, "brandSpokePrice");
            return (Criteria) this;
        }

        public Criteria andBrandSpokePriceGreaterThanOrEqualTo(Float value) {
            addCriterion("brand_spoke_price >=", value, "brandSpokePrice");
            return (Criteria) this;
        }

        public Criteria andBrandSpokePriceLessThan(Float value) {
            addCriterion("brand_spoke_price <", value, "brandSpokePrice");
            return (Criteria) this;
        }

        public Criteria andBrandSpokePriceLessThanOrEqualTo(Float value) {
            addCriterion("brand_spoke_price <=", value, "brandSpokePrice");
            return (Criteria) this;
        }

        public Criteria andBrandSpokePriceIn(List<Float> values) {
            addCriterion("brand_spoke_price in", values, "brandSpokePrice");
            return (Criteria) this;
        }

        public Criteria andBrandSpokePriceNotIn(List<Float> values) {
            addCriterion("brand_spoke_price not in", values, "brandSpokePrice");
            return (Criteria) this;
        }

        public Criteria andBrandSpokePriceBetween(Float value1, Float value2) {
            addCriterion("brand_spoke_price between", value1, value2, "brandSpokePrice");
            return (Criteria) this;
        }

        public Criteria andBrandSpokePriceNotBetween(Float value1, Float value2) {
            addCriterion("brand_spoke_price not between", value1, value2, "brandSpokePrice");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNull() {
            addCriterion("platform is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("platform is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(String value) {
            addCriterion("platform =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(String value) {
            addCriterion("platform <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(String value) {
            addCriterion("platform >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(String value) {
            addCriterion("platform >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(String value) {
            addCriterion("platform <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(String value) {
            addCriterion("platform <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLike(String value) {
            addCriterion("platform like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotLike(String value) {
            addCriterion("platform not like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<String> values) {
            addCriterion("platform in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<String> values) {
            addCriterion("platform not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(String value1, String value2) {
            addCriterion("platform between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(String value1, String value2) {
            addCriterion("platform not between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIsNull() {
            addCriterion("platform_name is null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIsNotNull() {
            addCriterion("platform_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameEqualTo(String value) {
            addCriterion("platform_name =", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotEqualTo(String value) {
            addCriterion("platform_name <>", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThan(String value) {
            addCriterion("platform_name >", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThanOrEqualTo(String value) {
            addCriterion("platform_name >=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThan(String value) {
            addCriterion("platform_name <", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThanOrEqualTo(String value) {
            addCriterion("platform_name <=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLike(String value) {
            addCriterion("platform_name like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotLike(String value) {
            addCriterion("platform_name not like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIn(List<String> values) {
            addCriterion("platform_name in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotIn(List<String> values) {
            addCriterion("platform_name not in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameBetween(String value1, String value2) {
            addCriterion("platform_name between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotBetween(String value1, String value2) {
            addCriterion("platform_name not between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andFansCountIsNull() {
            addCriterion("fans_count is null");
            return (Criteria) this;
        }

        public Criteria andFansCountIsNotNull() {
            addCriterion("fans_count is not null");
            return (Criteria) this;
        }

        public Criteria andFansCountEqualTo(Integer value) {
            addCriterion("fans_count =", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountNotEqualTo(Integer value) {
            addCriterion("fans_count <>", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountGreaterThan(Integer value) {
            addCriterion("fans_count >", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("fans_count >=", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountLessThan(Integer value) {
            addCriterion("fans_count <", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountLessThanOrEqualTo(Integer value) {
            addCriterion("fans_count <=", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountIn(List<Integer> values) {
            addCriterion("fans_count in", values, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountNotIn(List<Integer> values) {
            addCriterion("fans_count not in", values, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountBetween(Integer value1, Integer value2) {
            addCriterion("fans_count between", value1, value2, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountNotBetween(Integer value1, Integer value2) {
            addCriterion("fans_count not between", value1, value2, "fansCount");
            return (Criteria) this;
        }

        public Criteria andGiftToMoneyIsNull() {
            addCriterion("gift_to_money is null");
            return (Criteria) this;
        }

        public Criteria andGiftToMoneyIsNotNull() {
            addCriterion("gift_to_money is not null");
            return (Criteria) this;
        }

        public Criteria andGiftToMoneyEqualTo(Float value) {
            addCriterion("gift_to_money =", value, "giftToMoney");
            return (Criteria) this;
        }

        public Criteria andGiftToMoneyNotEqualTo(Float value) {
            addCriterion("gift_to_money <>", value, "giftToMoney");
            return (Criteria) this;
        }

        public Criteria andGiftToMoneyGreaterThan(Float value) {
            addCriterion("gift_to_money >", value, "giftToMoney");
            return (Criteria) this;
        }

        public Criteria andGiftToMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("gift_to_money >=", value, "giftToMoney");
            return (Criteria) this;
        }

        public Criteria andGiftToMoneyLessThan(Float value) {
            addCriterion("gift_to_money <", value, "giftToMoney");
            return (Criteria) this;
        }

        public Criteria andGiftToMoneyLessThanOrEqualTo(Float value) {
            addCriterion("gift_to_money <=", value, "giftToMoney");
            return (Criteria) this;
        }

        public Criteria andGiftToMoneyIn(List<Float> values) {
            addCriterion("gift_to_money in", values, "giftToMoney");
            return (Criteria) this;
        }

        public Criteria andGiftToMoneyNotIn(List<Float> values) {
            addCriterion("gift_to_money not in", values, "giftToMoney");
            return (Criteria) this;
        }

        public Criteria andGiftToMoneyBetween(Float value1, Float value2) {
            addCriterion("gift_to_money between", value1, value2, "giftToMoney");
            return (Criteria) this;
        }

        public Criteria andGiftToMoneyNotBetween(Float value1, Float value2) {
            addCriterion("gift_to_money not between", value1, value2, "giftToMoney");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Float value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Float value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Float value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Float value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Float value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Float value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Float> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Float> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Float value1, Float value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Float value1, Float value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Float value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Float value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Float value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Float value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Float value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Float value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Float> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Float> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Float value1, Float value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Float value1, Float value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andBreastIsNull() {
            addCriterion("breast is null");
            return (Criteria) this;
        }

        public Criteria andBreastIsNotNull() {
            addCriterion("breast is not null");
            return (Criteria) this;
        }

        public Criteria andBreastEqualTo(Float value) {
            addCriterion("breast =", value, "breast");
            return (Criteria) this;
        }

        public Criteria andBreastNotEqualTo(Float value) {
            addCriterion("breast <>", value, "breast");
            return (Criteria) this;
        }

        public Criteria andBreastGreaterThan(Float value) {
            addCriterion("breast >", value, "breast");
            return (Criteria) this;
        }

        public Criteria andBreastGreaterThanOrEqualTo(Float value) {
            addCriterion("breast >=", value, "breast");
            return (Criteria) this;
        }

        public Criteria andBreastLessThan(Float value) {
            addCriterion("breast <", value, "breast");
            return (Criteria) this;
        }

        public Criteria andBreastLessThanOrEqualTo(Float value) {
            addCriterion("breast <=", value, "breast");
            return (Criteria) this;
        }

        public Criteria andBreastIn(List<Float> values) {
            addCriterion("breast in", values, "breast");
            return (Criteria) this;
        }

        public Criteria andBreastNotIn(List<Float> values) {
            addCriterion("breast not in", values, "breast");
            return (Criteria) this;
        }

        public Criteria andBreastBetween(Float value1, Float value2) {
            addCriterion("breast between", value1, value2, "breast");
            return (Criteria) this;
        }

        public Criteria andBreastNotBetween(Float value1, Float value2) {
            addCriterion("breast not between", value1, value2, "breast");
            return (Criteria) this;
        }

        public Criteria andWaistlineIsNull() {
            addCriterion("waistline is null");
            return (Criteria) this;
        }

        public Criteria andWaistlineIsNotNull() {
            addCriterion("waistline is not null");
            return (Criteria) this;
        }

        public Criteria andWaistlineEqualTo(Float value) {
            addCriterion("waistline =", value, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineNotEqualTo(Float value) {
            addCriterion("waistline <>", value, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineGreaterThan(Float value) {
            addCriterion("waistline >", value, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineGreaterThanOrEqualTo(Float value) {
            addCriterion("waistline >=", value, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineLessThan(Float value) {
            addCriterion("waistline <", value, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineLessThanOrEqualTo(Float value) {
            addCriterion("waistline <=", value, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineIn(List<Float> values) {
            addCriterion("waistline in", values, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineNotIn(List<Float> values) {
            addCriterion("waistline not in", values, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineBetween(Float value1, Float value2) {
            addCriterion("waistline between", value1, value2, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineNotBetween(Float value1, Float value2) {
            addCriterion("waistline not between", value1, value2, "waistline");
            return (Criteria) this;
        }

        public Criteria andHiplineIsNull() {
            addCriterion("hipline is null");
            return (Criteria) this;
        }

        public Criteria andHiplineIsNotNull() {
            addCriterion("hipline is not null");
            return (Criteria) this;
        }

        public Criteria andHiplineEqualTo(Float value) {
            addCriterion("hipline =", value, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineNotEqualTo(Float value) {
            addCriterion("hipline <>", value, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineGreaterThan(Float value) {
            addCriterion("hipline >", value, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineGreaterThanOrEqualTo(Float value) {
            addCriterion("hipline >=", value, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineLessThan(Float value) {
            addCriterion("hipline <", value, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineLessThanOrEqualTo(Float value) {
            addCriterion("hipline <=", value, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineIn(List<Float> values) {
            addCriterion("hipline in", values, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineNotIn(List<Float> values) {
            addCriterion("hipline not in", values, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineBetween(Float value1, Float value2) {
            addCriterion("hipline between", value1, value2, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineNotBetween(Float value1, Float value2) {
            addCriterion("hipline not between", value1, value2, "hipline");
            return (Criteria) this;
        }

        public Criteria andExpierenceIsNull() {
            addCriterion("expierence is null");
            return (Criteria) this;
        }

        public Criteria andExpierenceIsNotNull() {
            addCriterion("expierence is not null");
            return (Criteria) this;
        }

        public Criteria andExpierenceEqualTo(String value) {
            addCriterion("expierence =", value, "expierence");
            return (Criteria) this;
        }

        public Criteria andExpierenceNotEqualTo(String value) {
            addCriterion("expierence <>", value, "expierence");
            return (Criteria) this;
        }

        public Criteria andExpierenceGreaterThan(String value) {
            addCriterion("expierence >", value, "expierence");
            return (Criteria) this;
        }

        public Criteria andExpierenceGreaterThanOrEqualTo(String value) {
            addCriterion("expierence >=", value, "expierence");
            return (Criteria) this;
        }

        public Criteria andExpierenceLessThan(String value) {
            addCriterion("expierence <", value, "expierence");
            return (Criteria) this;
        }

        public Criteria andExpierenceLessThanOrEqualTo(String value) {
            addCriterion("expierence <=", value, "expierence");
            return (Criteria) this;
        }

        public Criteria andExpierenceLike(String value) {
            addCriterion("expierence like", value, "expierence");
            return (Criteria) this;
        }

        public Criteria andExpierenceNotLike(String value) {
            addCriterion("expierence not like", value, "expierence");
            return (Criteria) this;
        }

        public Criteria andExpierenceIn(List<String> values) {
            addCriterion("expierence in", values, "expierence");
            return (Criteria) this;
        }

        public Criteria andExpierenceNotIn(List<String> values) {
            addCriterion("expierence not in", values, "expierence");
            return (Criteria) this;
        }

        public Criteria andExpierenceBetween(String value1, String value2) {
            addCriterion("expierence between", value1, value2, "expierence");
            return (Criteria) this;
        }

        public Criteria andExpierenceNotBetween(String value1, String value2) {
            addCriterion("expierence not between", value1, value2, "expierence");
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