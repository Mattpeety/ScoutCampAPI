package pl.scoutCamp.api.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.scoutCamp.api.controller.rest.JsonViews;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamCategorizationSheetDTO {

    @JsonView(JsonViews.NoRankingView.class)
    Integer id;
    @JsonView(JsonViews.NoRankingView.class)
    Boolean isDraft;
    @JsonView(JsonViews.RankingView.class)
    Integer points;
    @JsonView(JsonViews.RankingView.class)
    Timestamp createdAt;
    @JsonView(JsonViews.RankingView.class)
    Timestamp updatedAt;
    @JsonView(JsonViews.NoRankingView.class)
    CategorizationSheetDTO categorizationSheet;
    @JsonView(JsonViews.RankingView.class)
    TeamDTO team;
    @JsonView(JsonViews.RankingView.class)
    CategoryDTO category;
}
