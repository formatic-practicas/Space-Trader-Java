/*******************************************************************************
 *
 * Space Trader for Windows 2.00
 *
 * Copyright (C) 2005 Jay French, All Rights Reserved
 *
 * Additional coding by David Pierron
 * Original coding by Pieter Spronck, Sam Anderson, Samuel Goldstein, Matt Lee
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * If you'd like a copy of the GNU General Public License, go to
 * http://www.gnu.org/copyleft/gpl.html.
 *
 * You can contact the author at spacetrader@frenchfryz.com
 *
 ******************************************************************************/
package spacetrader.enums;

public enum AlertType implements SpaceTraderEnum
{
	Alert,
	AntidoteOnBoard,
	AntidoteDestroyed,
	AntidoteTaken,
	AppStart,
	ArrivalBuyNewspaper,
	ArrivalIFFuel,
	ArrivalIFFuelRepairs,
	ArrivalIFNewspaper,
	ArrivalIFRepairs,
	ArtifactLost,
	ArtifactRelinquished,
	CargoIF,
	CargoNoEmptyBays,
	CargoNoneAvailable,
	CargoNoneToSell,
	CargoNotInterested,
	CargoNotSold,
	ChartJump,
	ChartJumpCurrent,
	ChartJumpNoSystemSelected,
	ChartTrackSystem,
	ChartWormholeUnreachable,
	Cheater,
	CrewFireMercenary,
	CrewNoQuarters,
	DebtNoBuy,
	DebtNone,
	DebtReminder,
	DebtTooLargeGrounded,
	DebtTooLargeLoan,
	DebtTooLargeTrade,
	DebtWarning,
	Egg,
	EncounterAliensSurrender,
	EncounterArrested,
	EncounterAttackCaptain,
	EncounterAttackNoDisruptors,
	EncounterAttackNoLasers,
	EncounterAttackNoWeapons,
	EncounterAttackPolice,
	EncounterAttackTrader,
	EncounterBothDestroyed,
	EncounterDisabledOpponent,
	EncounterDrinkContents,
	EncounterDumpAll,
	EncounterDumpWarning,
	EncounterEscaped,
	EncounterEscapedHit,
	EncounterEscapePodActivated,
	EncounterLooting,
	EncounterMarieCeleste,
	EncounterMarieCelesteNoBribe,
	EncounterOpponentEscaped,
	EncounterPiratesBounty,
	EncounterPiratesExamineReactor,
	EncounterPiratesFindNoCargo,
	EncounterPiratesSurrenderPrincess,
	EncounterPiratesTakeSculpture,
	EncounterPoliceBribe,
	EncounterPoliceBribeCant,
	EncounterPoliceBribeLowCash,
	EncounterPoliceFine,
	EncounterPoliceNothingFound,
	EncounterPoliceNothingIllegal,
	EncounterPoliceSubmit,
	EncounterPoliceSurrender,
	EncounterPostMarie,
	EncounterPostMarieFlee,
	EncounterScoop,
	EncounterScoopNoRoom,
	EncounterScoopNoScoop,
	EncounterSurrenderRefused,
	EncounterTonicConsumedGood,
	EncounterTonicConsumedStrange,
	EncounterTradeCompleted,
	EncounterYouLose,
	EncounterYouWin,
	EquipmentAlreadyOwn,
	EquipmentBuy,
	EquipmentEscapePod,
	EquipmentExtraBaysInUse,
	EquipmentFuelCompactor,
	EquipmentHiddenCompartments,
	EquipmentIF,
	EquipmentLightningShield,
	EquipmentMorgansLaser,
	EquipmentNotEnoughSlots,
	EquipmentQuantumDisruptor,
	EquipmentSell,
	FileErrorOpen,
	FileErrorSave,
	FleaBuilt,
	GameAbandonConfirm,
	GameClearHighScores,
	GameEndBoughtMoon,
	GameEndBoughtMoonGirl,
	GameEndHighScoreAchieved,
	GameEndHighScoreCheat,
	GameEndHighScoreMissed,
	GameEndKilled,
	GameEndRetired,
	GameEndScore,
	GameRetire,
	InsuranceNoEscapePod,
	InsurancePayoff,
	InsuranceStop,
	JailConvicted,
	JailFleaReceived,
	JailHiddenCargoBaysRemoved,
	JailIllegalGoodsImpounded,
	JailInsuranceLost,
	JailMercenariesLeave,
	JailShipSold,
	JarekTakenHome,
	LeavingIFInsurance,
	LeavingIFMercenaries,
	LeavingIFWormholeTax,
	MeetCaptainAhab,
	MeetCaptainConrad,
	MeetCaptainHuie,
	NewGameConfirm,
	NewGameMoreSkillPoints,
	OptionsNoGame,
	PreciousHidden,
	PrincessTakenHome,
	ReactorConfiscated,
	ReactorDestroyed,
	ReactorOnBoard,
	ReactorMeltdown,
	ReactorWarningFuel,
	ReactorWarningFuelGone,
	ReactorWarningTemp,
	RegistryError,
	SculptureConfiscated,
	SculptureSaved,
	ShipBuyConfirm,
	ShipBuyCrewQuarters,
	ShipBuyIF,
	ShipBuyIFTransfer,
	ShipBuyNoSlots,
	ShipBuyNotAvailable,
	ShipBuyNoTransfer,
	ShipBuyPassengerQuarters,
	ShipBuyReactor,
	ShipBuyTransfer,
	ShipDesignIF,
	ShipDesignThanks,
	ShipHullUpgraded,
	SpecialCleanRecord,
	SpecialExperimentPerformed,
	SpecialIF,
	SpecialMoonBought,
	SpecialNoQuarters,
	SpecialNotEnoughBays,
	SpecialPassengerConcernedJarek,
	SpecialPassengerConcernedPrincess,
	SpecialPassengerConcernedWild,
	SpecialPassengerImpatientJarek,
	SpecialPassengerImpatientPrincess,
	SpecialPassengerImpatientWild,
	SpecialPassengerOnBoard,
	SpecialSealedCanisters,
	SpecialSkillIncrease,
	SpecialTimespaceFabricRip,
	SpecialTrainingCompleted,
	TravelArrival,
	TravelUneventfulTrip,
	TribblesAllDied,
	TribblesAteFood,
	TribblesGone,
	TribblesHalfDied,
	TribblesKilled,
	TribblesMostDied,
	TribblesOwn,
	TribblesRemoved,
	TribblesInspector,
	TribblesSqueek,
	TribblesTradeIn,
	WildArrested,
	WildChatsPirates,
	WildGoesPirates,
	WildLeavesShip,
	WildSculpture,
	WildWontBoardLaser,
	WildWontBoardReactor,
	WildWontStayAboardLaser,
	WildWontStayAboardReactor;

	public int CastToInt()
	{
return ordinal();
	}
}