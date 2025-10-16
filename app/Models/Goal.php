<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

/**
 * Class Goal
 *
 * @property int $id
 * @property int $id_equipe
 * @property int $id_match
 * @property float|null $vitesse
 *
 * @property Team $team
 * @property Match $match
 *
 * @package App\Models
 */
class Goal extends Model
{
	protected $table = 'goal';
	public $timestamps = false;

	protected $casts = [
		'id_equipe' => 'int',
		'id_match' => 'int',
		'vitesse' => 'float'
	];

	protected $fillable = [
		'id_equipe',
		'id_match',
		'vitesse'
	];

	public function team()
	{
		return $this->belongsTo(Team::class, 'id_equipe');
	}

	public function match()
	{
		return $this->belongsTo(Matches::class, 'id_match');
	}
}
