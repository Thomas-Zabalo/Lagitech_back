<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Carbon\Carbon;
use Illuminate\Database\Eloquent\Collection;
use Illuminate\Database\Eloquent\Model;

/**
 * Class Match
 *
 * @property int $id
 * @property int|null $score_1
 * @property int|null $score_2
 * @property int $id_equipe_1
 * @property int $id_equipe_2
 * @property float|null $vitesse_max
 * @property int $babyfoot_id
 * @property Carbon|null $created_at
 *
 * @property Team $team
 * @property Babyfoot $babyfoot
 * @property Collection|Goal[] $goals
 *
 * @package App\Models
 */
class Matches extends Model
{
	protected $table = 'matches';
	public $timestamps = false;

	protected $casts = [
		'score_1' => 'int',
		'score_2' => 'int',
		'id_equipe_1' => 'int',
		'id_equipe_2' => 'int',
		'vitesse_max' => 'float',
		'babyfoot_id' => 'int'
	];

	protected $fillable = [
		'score_1',
		'score_2',
		'id_equipe_1',
		'id_equipe_2',
		'vitesse_max',
		'babyfoot_id'
	];

	public function team()
	{
		return $this->belongsTo(Team::class, 'id_equipe_2');
	}

	public function babyfoot()
	{
		return $this->belongsTo(Babyfoot::class);
	}

	public function goals()
	{
		return $this->hasMany(Goal::class, 'id_match');
	}
}
