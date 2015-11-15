package fr.benito.dalmeida.fdj.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import fr.benito.dalmeida.fdj.domain.utils.BadInitialiseException;

public class LottoDraw {

    private final Integer[] standardNumberDraw;
    private final Integer[] starNumberDraw;
    private Date lottoDrawDay;

    public LottoDraw(int nbStandarNumbers, int nbStarNumber) {
        standardNumberDraw = new Integer[nbStandarNumbers];
        starNumberDraw = new Integer[nbStarNumber];
    }

    public LottoDraw(int nbStandarNumbers, int nbStarNumber, Date lottoDrawDay) {
        standardNumberDraw = new Integer[nbStandarNumbers];
        starNumberDraw = new Integer[nbStarNumber];
        this.lottoDrawDay = lottoDrawDay;
    }

    public void populate(List<Integer> standardChosenNumbers, List<Integer> starChosenNumbers) {
        if (standardChosenNumbers.size() != standardNumberDraw.length)
            throw new BadInitialiseException();
        if (starChosenNumbers != null && starChosenNumbers != null
                && standardChosenNumbers.size() != starNumberDraw.length)
            throw new BadInitialiseException();
        for (int i = 0; i < standardNumberDraw.length; i++) {
            standardNumberDraw[i] = standardChosenNumbers.get(i);
        }
        for (int i = 0; i < starNumberDraw.length; i++) {
            starNumberDraw[i] = starChosenNumbers.get(i);
        }
    }

    public Integer[] getStandardNumberDraw() {
        return standardNumberDraw;
    }

    public Integer[] getStarNumberDraw() {
        return starNumberDraw;
    }

    public Date getLottoDrawDay() {
        return lottoDrawDay;
    }

    public void setLottoDrawDay(Date lottoDrawDay) {
        this.lottoDrawDay = lottoDrawDay;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (lottoDrawDay == null ? 0 : lottoDrawDay.hashCode());
        result = prime * result + Arrays.hashCode(standardNumberDraw);
        result = prime * result + Arrays.hashCode(starNumberDraw);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LottoDraw other = (LottoDraw) obj;
        if (lottoDrawDay == null) {
            if (other.lottoDrawDay != null)
                return false;
        } else if (!lottoDrawDay.equals(other.lottoDrawDay))
            return false;
        if (!Arrays.equals(standardNumberDraw, other.standardNumberDraw))
            return false;
        if (!Arrays.equals(starNumberDraw, other.starNumberDraw))
            return false;
        return true;
    }

}
