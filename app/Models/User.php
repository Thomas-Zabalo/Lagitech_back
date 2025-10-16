<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Carbon\Carbon;
use Illuminate\Database\Eloquent\Model;

/**
 * Class User
 * 
 * @property int $id
 * @property string $name
 * @property string $surname
 * @property string|null $addresse
 * @property string $mdp
 * @property int|null $team_id
 * @property bool|null $is_admin
 * @property Carbon $created_at
 * 
 * @property Team|null $team
 *
 * @package App\Models
 */
class User extends Model
{
	protected $table = 'users';
	public $timestamps = false;

	protected $casts = [
		'team_id' => 'int',
		'is_admin' => 'bool'
	];

	protected $fillable = [
		'name',
		'surname',
		'addresse',
		'mdp',
		'team_id',
		'is_admin'
	];

	public function team()
	{
		return $this->belongsTo(Team::class);
	}
}
