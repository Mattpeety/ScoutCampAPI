package pl.scoutCamp.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.scoutCamp.api.dto.RankingDTO;
import pl.scoutCamp.domain.Ranking;

@Mapper(componentModel = "spring")
public interface RankingMapper {

    RankingDTO map (Ranking ranking);
}
