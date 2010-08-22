package com.starillon.ibtradetools.contract;

import com.ib.client.Contract;

public class ContractDataCriteria {
    private Contract contract;
    private BarSize barSize;
    private DateFormat dateFormat;
    private Duration duration;
    private MarketDataType marketDataType;
    private RegularTradingHours regularTradingHours;
    private int durationAmount;
    private static final String SPACE = " ";

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getBarSize() {
        return (barSize != null) ? barSize.toString() : null;
    }

    public void setBarSize(BarSize barSize) {
        this.barSize = barSize;
    }

    public int getDateFormat() {
        return (dateFormat != null) ? dateFormat.getDateFormat() : 2;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getDuration() {
        return (duration != null) ? durationAmount + SPACE + duration.toString() : null;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getMarketDataType() {
        return (marketDataType != null) ? marketDataType.toString() : null;
    }

    public void setMarketDataType(MarketDataType marketDataType) {
        this.marketDataType = marketDataType;
    }

    public int getRegularTradingHours() {
        return (regularTradingHours != null) ? regularTradingHours.getRegularHours() : 0;
    }

    public void setRegularTradingHours(RegularTradingHours regularTradingHours) {
        this.regularTradingHours = regularTradingHours;
    }

    public void setDurationAmount(int durationAmount) {
        this.durationAmount = durationAmount;
    }
}
