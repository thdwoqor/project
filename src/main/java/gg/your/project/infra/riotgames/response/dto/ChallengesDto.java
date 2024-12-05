package gg.your.project.infra.riotgames.response.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record ChallengesDto(
        @JsonProperty("12AssistStreakCount")
        Integer assistStreakCount,
        Integer baronBuffGoldAdvantageOverThreshold,
        Double controlWardTimeCoverageInRiverOrEnemyHalf,
        Integer earliestBaron,
        Integer earliestDragonTakedown,
        Integer earliestElderDragon,
        Integer earlyLaningPhaseGoldExpAdvantage,
        Integer fasterSupportQuestCompletion,
        Integer fastestLegendary,
        Integer hadAfkTeammate,
        Integer highestChampionDamage,
        Integer highestCrowdControlScore,
        Integer highestWardKills,
        Integer junglerKillsEarlyJungle,
        Integer killsOnLanersEarlyJungleAsJungler,
        Integer laningPhaseGoldExpAdvantage,
        Integer legendaryCount,
        Double maxCsAdvantageOnLaneOpponent,
        Integer maxLevelLeadLaneOpponent,
        Integer mostWardsDestroyedOneSweeper,
        Integer mythicItemUsed,
        Integer playedChampSelectPosition,
        Integer soloTurretsLategame,
        Integer takedownsFirst25Minutes,
        Integer teleportTakedowns,
        Integer thirdInhibitorDestroyedTime,
        Integer threeWardsOneSweeperCount,
        Double visionScoreAdvantageLaneOpponent,
        Integer infernalScalePickup,
        Integer fistBumpParticipation,
        Integer voidMonsterKill,
        Integer abilityUses,
        Integer acesBefore15Minutes,
        Double alliedJungleMonsterKills,
        Integer baronTakedowns,
        Integer blastConeOppositeOpponentCount,
        Integer bountyGold,
        Integer buffsStolen,
        Integer completeSupportQuestInTime,
        Integer controlWardsPlaced,
        Double damagePerMinute,
        Double damageTakenOnTeamPercentage,
        Integer dancedWithRiftHerald,
        Integer deathsByEnemyChamps,
        Integer dodgeSkillShotsSmallWindow,
        Integer doubleAces,
        Integer dragonTakedowns,
        List<Integer> legendaryItemUsed,
        Double effectiveHealAndShielding,
        Integer elderDragonKillsWithOpposingSoul,
        Integer elderDragonMultikills,
        Integer enemyChampionImmobilizations,
        Double enemyJungleMonsterKills,
        Integer epicMonsterKillsNearEnemyJungler,
        Integer epicMonsterKillsWithin30SecondsOfSpawn,
        Integer epicMonsterSteals,
        Integer epicMonsterStolenWithoutSmite,
        Integer firstTurretKilled,
        Double firstTurretKilledTime,
        Integer flawlessAces,
        Integer fullTeamTakedown,
        Double gameLength,
        Integer getTakedownsInAllLanesEarlyJungleAsLaner,
        Double goldPerMinute,
        Integer hadOpenNexus,
        Integer immobilizeAndKillWithAlly,
        Integer initialBuffCount,
        Integer initialCrabCount,
        Double jungleCsBefore10Minutes,
        Integer junglerTakedownsNearDamagedEpicMonster,
        Double kda,
        Integer killAfterHiddenWithAlly,
        Integer killedChampTookFullTeamDamageSurvived,
        Integer killingSprees,
        Double killParticipation,
        Integer killsNearEnemyTurret,
        Integer killsOnOtherLanesEarlyJungleAsLaner,
        Integer killsOnRecentlyHealedByAramPack,
        Integer killsUnderOwnTurret,
        Integer killsWithHelpFromEpicMonster,
        Integer knockEnemyIntoTeamAndKill,
        Integer kTurretsDestroyedBeforePlatesFall,
        Integer landSkillShotsEarlyGame,
        Integer laneMinionsFirst10Minutes,
        Integer lostAnInhibitor,
        Integer maxKillDeficit,
        Integer mejaisFullStackInTime,
        Double moreEnemyJungleThanOpponent,
        Integer multiKillOneSpell,
        Integer multikills,
        Integer multikillsAfterAggressiveFlash,
        Integer multiTurretRiftHeraldCount,
        Integer outerTurretExecutesBefore10Minutes,
        Integer outnumberedKills,
        Integer outnumberedNexusKill,
        Integer perfectDragonSoulsTaken,
        Integer perfectGame,
        Integer pickKillWithAlly,
        Integer poroExplosions,
        Integer quickCleanse,
        Integer quickFirstTurret,
        Integer quickSoloKills,
        Integer riftHeraldTakedowns,
        Integer saveAllyFromDeath,
        Integer scuttleCrabKills,
        Double shortestTimeToAceFromFirstTakedown,
        Integer skillshotsDodged,
        Integer skillshotsHit,
        Integer snowballsHit,
        Integer soloBaronKills,
        @JsonProperty("SWARM_DefeatAatrox")
        Integer swarmDefeatAatrox,
        @JsonProperty("SWARM_DefeatBriar")
        Integer swarmDefeatBriar,
        @JsonProperty("SWARM_DefeatMiniBosses")
        Integer swarmDefeatMiniBosses,
        @JsonProperty("SWARM_EvolveWeapon")
        Integer swarmEvolveWeapon,
        @JsonProperty("SWARM_Have3Passives")
        Integer swarmHave3Passives,
        @JsonProperty("SWARM_KillEnemy")
        Integer swarmKillEnemy,
        @JsonProperty("SWARM_PickupGold")
        Double swarmPickupGold,
        @JsonProperty("SWARM_ReachLevel50")
        Integer swarmReachLevel50,
        @JsonProperty("SWARM_Survive15Min")
        Integer swarmSurvive15Min,
        @JsonProperty("SWARM_WinWith5EvolvedWeapons")
        Integer swarmWinWith5EvolvedWeapons,
        Integer soloKills,
        Integer stealthWardsPlaced,
        Integer survivedSingleDigitHpCount,
        Integer survivedThreeImmobilizesInFight,
        Integer takedownOnFirstTurret,
        Integer takedowns,
        Integer takedownsAfterGainingLevelAdvantage,
        Integer takedownsBeforeJungleMinionSpawn,
        Integer takedownsFirstXMinutes,
        Integer takedownsInAlcove,
        Integer takedownsInEnemyFountain,
        Integer teamBaronKills,
        Double teamDamagePercentage,
        Integer teamElderDragonKills,
        Integer teamRiftHeraldKills,
        Integer tookLargeDamageSurvived,
        Integer turretPlatesTaken,
        Integer turretsTakenWithRiftHerald,
        Integer turretTakedowns,
        Integer twentyMinionsIn3SecondsCount,
        Integer twoWardsOneSweeperCount,
        Integer unseenRecalls,
        Double visionScorePerMinute,
        Integer wardsGuarded,
        Integer wardTakedowns,
        Integer wardTakedownsBefore20M
) {
}