package pl.scoutCamp.api.controller.rest;

public class JsonViews {

    public interface FullView extends NoRegimentView{}
    public interface NoRegimentView extends NoTroopView{}
    public interface NoTroopView{}
    public interface NoRankingView extends RankingView{}
    public interface RankingView{}




}
